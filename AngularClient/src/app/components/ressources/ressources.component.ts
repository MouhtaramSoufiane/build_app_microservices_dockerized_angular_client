import { Component, OnInit } from '@angular/core';
import { RessourceService } from 'src/app/services/ressource.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-ressources',
  templateUrl: './ressources.component.html',
  styleUrls: ['./ressources.component.css']
})


  export class RessourcesComponent implements OnInit {
    reservationId!: String;
    ressource:any;
    ressources:any;
    pages: number = 1;


  constructor(
      private ressourceService: RessourceService,
      private route: ActivatedRoute
    ) {}

    ngOnInit(): void {
      this.reservationId=this.route.snapshot.paramMap.get('id') ?? '';

      this.ressourceService.getRessourceById(this.reservationId).subscribe({
        next: data => {
          this.ressource=data.ressource;
          console.log(data.ressource);
        }
      });

      this.ressourceService.getAllRessources().subscribe({
        next:data=>{
          this.ressources=data;
        }
      })


    }


  }
