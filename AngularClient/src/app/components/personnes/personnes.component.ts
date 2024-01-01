import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PersonneService } from 'src/app/services/personne.service';

@Component({
  selector: 'app-personnes',
  templateUrl: './personnes.component.html',
  styleUrls: ['./personnes.component.css']
})
export class PersonnesComponent implements OnInit{
  public personnes:any;
  public pages:number=1;
  constructor(private personneService:PersonneService,private http:HttpClient,private router:Router){

  }

  ngOnInit(): void {
    this.personneService.getAllPersonnes().subscribe({
      next:data=>{
        this.personnes=data
        console.log(data)
      },
      error:err=>{
        console.log(err)
      }
    })
  }

  voirReservations(personneId:number){
    this.router.navigate(['reservations/personnes',personneId]);


  }

}
