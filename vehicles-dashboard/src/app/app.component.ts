import { Component, OnInit } from '@angular/core';
import { VehicleService } from './services/vehicle.service';  
import { Observable } from 'rxjs/Rx';  
import { Customer } from './models/customer';
import { Vehicle } from './models/vehicle';
import { VehicleStatus } from './models/vehicleStatus';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['../assets/css/bootstrap.min.css', '../assets/css/font-awesome.min.css']
})

export class AppComponent implements OnInit {
  private title = 'Vehicles Dashboard';
  private customers: Customer[] = []; 
  private originalCustomers: Customer[] = [];
  private customerNames: string[] = [];
  private status: string[] = ["Running", "Stopped"];
  private isFilterStatus = "";
  private isFilterName = "";


  constructor(private vehicleService: VehicleService) {  } 

  ngOnInit() {  
    this.vehicleService.getAllCustomers().subscribe((data) => { 
    	this.originalCustomers = data;
    	this.customers = data;
    	this.updateVehicleStatus();
    	this.createcustomerNamesList();
    }); 

    Observable.timer(0, 10000)
     .subscribe(() => {
        this.updateVehicleStatus();
      });
  }  

  createcustomerNamesList() {
  	for(let c of this.customers) {
  		this.customerNames.push(c.name);
  	}
  }

  updateVehicleStatus() {
	this.originalCustomers.forEach((c, i) => {
		for(let v of c.vehicle) {
			this.vehicleService.getVehicleStatus(v.id).subscribe((data) => { 
				 v.status = data.status;
			});
		}
		if(i == (this.originalCustomers.length-1)) {
			setTimeout(() =>
            {
	  			this.customers = this.originalCustomers;
				if(this.isFilterStatus != "" && this.isFilterStatus != "-1") {
			  		this.filterStatus(this.isFilterStatus);
			  	}
			  	if(this.isFilterName != "" && this.isFilterName != "-1") {
			  		this.filterName(this.isFilterName);
			  	}
            }, 500);
			
		}
	});

  }

  filterStatus(value) {
  	this.isFilterStatus = value;
  	if(value != "-1") {
  		let vehicles: Vehicle[] = [];
  		this.customers = [];
  		this.originalCustomers.forEach(c => {
  			for(let v of c.vehicle) {
  				if(v.status == value) {
  					vehicles.push(v);
  				}
  			}
  			if(vehicles.length > 0) {
	  			let customer = new Customer();
	  			customer.id = c.id;
	  			customer.name = c.name;
	  			customer.address = c.address;
	  			customer.vehicle = vehicles;
	  			this.customers.push(customer);
  				vehicles = [];
  			}
  		});

  	}
  	
  }

  filterName(value) {
  	this.customers = this.originalCustomers;
  	this.isFilterName = value;
  	if(value != "-1") {
  		this.customers = this.customers.filter(c => c.name == value);
  	}
  }

}
