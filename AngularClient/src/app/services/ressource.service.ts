import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RessourceService {

  constructor(private http:HttpClient) {

  }

  getAllRessources():Observable<any>{
    return this.http.get("http://localhost:9999/ressources-service/ressources");
  }
  getRessourceById(id: String): Observable<any>{
   return this.http.get(`http://localhost:9999/reservation-service/reservations/${id}`);
 }


}
