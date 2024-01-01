import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {Reservation} from "../model/Reservation";

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  constructor(private http:HttpClient) {

   }

   getAllReservations():Observable<any>{
      return this.http.get("http://localhost:9999/reservation-service/reservations",{
        headers:{
          "Access-Control-Allow-Origin":'*'
        }
      });
   }

   getAllReservationPerson(personneId:String):Observable<any>{
      return this.http.get(`http://localhost:9999/reservation-service/persons/${personneId}`);

   }

   deleteReservation(ressourceId:number){
     return this.http.delete(`http://localhost:9999/reservation-service/reservations/${ressourceId}`);
   }

  addReservation(reservation:Reservation):Observable<any>{
    return this.http.post(`http://localhost:9999/reservation-service/reservations`,reservation);

  }
}
