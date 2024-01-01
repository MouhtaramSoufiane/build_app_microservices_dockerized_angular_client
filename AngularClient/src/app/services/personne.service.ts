import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PersonneService {

  constructor(private http:HttpClient) { 

  }

  getAllPersonnes():Observable<any>{
    return this.http.get(`http://localhost:9999/reservation-service/persons`);
  }
  getReservationsByPersonneId(personneId:number){
    return this.http.get(`http://localhost:9999/reservation-service/persons/${personneId}`)
  }
}
