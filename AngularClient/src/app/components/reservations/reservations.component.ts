import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ReservationService } from 'src/app/services/reservation.service';
import {FormBuilder, FormControl, FormControlName, FormGroup, Validators} from "@angular/forms";
import {Reservation} from "../../model/Reservation";
import { SecurityService } from 'src/app/services/security.service';


@Component({
  selector: 'app-reservations',
  templateUrl: './reservations.component.html',
  styleUrls: ['./reservations.component.css']
})
export class ReservationsComponent {
  personneId!:String;
  reservations!:any;
  reservationsPersonnes:any;
  editRes:FormGroup;
  addRes:FormGroup;
  reservation!:Reservation;
  options: string[] = ['MATERIEL_INF0', 'MATERIEL_AUDIO_VUSUEL'];
  pages: number = 1;

  constructor(public securityService :SecurityService,private formBuilder: FormBuilder,private http:HttpClient,public reservationService:ReservationService,private route:ActivatedRoute,private router:Router){


    this.editRes=this.formBuilder.group({
      nom: ['', Validators.required],
      context: [''],
      date: ['', Validators.required],
      duree: ['', Validators.required],
    });

    this.addRes=this.formBuilder.group({
      nom: ['', Validators.required],
      context: [''],
      date: ['', Validators.required],
      duree: ['', Validators.required],
      personne_nom:['',Validators.required],
      personne_email:['',Validators.required],
      personne_fonction:['',Validators.required],
      ressource_nom:['',Validators.required],
      ressource_type:['',Validators.required]
    });

    this.reservation=new Reservation();

  }

  ngOnInit(): void {
    this.personneId=this.route.snapshot.paramMap.get('id') ?? '';
    console.log(this.personneId)
    if(window.location.href=="http://localhost:4200/reservations"){
      this.getAllRessources();
    }else{
      this.getRessourcesPersonnes(this.personneId);
    }
  }

  getAllRessources(){
    this.reservationService.getAllReservations().subscribe(
      (data)=>{
        this.reservations=data;
        console.log(data);
      }
    )
  }

  handleDeleteReservation(reservationId:number){
    this.getAllReservations();
   this.reservationService.deleteReservation(reservationId).subscribe();
   this.getAllReservations();


  }

  voirRessource(ressourceId:number){
    this.router.navigate(["/ressources",ressourceId])

  }

  getRessourcesPersonnes(personneId:String){
   this.reservationService.getAllReservationPerson(personneId).subscribe({
         next:data=>{
          this.reservationsPersonnes=data.reservations;
         }
   })
  }

  handleEditReservation(reservation:any){
    this.editRes=this.formBuilder.group({
      nom: [reservation.nom, Validators.required],
      context: [reservation.context],
      date: [reservation.date, Validators.required],
      duree: [reservation.duree, Validators.required],
    });

    this.reservation.id=reservation.id;
    this.reservation.nom=this.editRes.value.nom;
    this.reservation.context=this.editRes.value.context;
    this.reservation.date=this.editRes.value.date;
    this.reservation.duree=this.editRes.value.duree;
    this.reservation.personne=reservation.personne;
    this.reservation.ressource=reservation.ressource;
    this.reservation.ressourceId=reservation.ressourceId;
    console.log(this.reservation,this.editRes.value.context);
  }

  validEditReservation(){
    if(confirm('est ce que vous etes sure ?')){
      this.reservation.nom=this.editRes.value.nom;
      this.reservation.context=this.editRes.value.context;
      this.reservation.date=this.editRes.value.date;
      this.reservation.duree=this.editRes.value.duree;
      console.log(this.reservation);
      this.http.put<any>(`http://localhost:9999/reservation-service/reservations/${this.reservation.id}`,this.reservation).subscribe({
        next:data=>{
          console.log(data);
          this.getAllReservations();
        }
      });
    }



  }

  handleAddReservation(){
    this.reservation.nom=this.addRes.value.nom;
    this.reservation.context=this.addRes.value.context;
    this.reservation.date=this.addRes.value.date;
    this.reservation.duree=this.addRes.value.duree;

    this.reservation.personne.nom=this.addRes.value.personne_nom;
    this.reservation.personne.email=this.addRes.value.personne_email;
    this.reservation.personne.fonction=this.addRes.value.personne_fonction;
    this.reservation.ressource.nom=this.addRes.value.ressource_nom;
    this.reservation.ressource.ressourceType=this.addRes.value.ressource_type;

    console.log(this.reservation)
    this.reservationService.addReservation(this.reservation).subscribe({
      next:data=>{
        console.log(data)
      },
      error:err=>{
        console.log(err)
      }
    })



  }


  getAllReservations(){
    this.reservationService.getAllReservations().subscribe({
      next:data=>{
        this.reservations=data;
      },
      error:err => {
        console.log(err)

      }
    })
  }


}
