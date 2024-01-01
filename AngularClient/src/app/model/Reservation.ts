export class Reservation {
  id: number;
  nom: string;
  context: string;
  date: string;
  duree: number;
  ressourceId: number;
  personne: {
    id: number;
    nom: string;
    email: string;
    fonction: string;
  };
  ressource: {
    id: number;
    nom: string;
    ressourceType: string;
  };

  constructor() {
    this.id = 0;
    this.nom = '';
    this.context = '';
    this.date = '';
    this.duree = 0;
    this.ressourceId = 0;
    this.personne = { id: 0, nom: '', email: '', fonction: '' };
    this.ressource = { id: 0, nom: '', ressourceType: '' };
  }
}
