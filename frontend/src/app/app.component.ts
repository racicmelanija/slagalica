import { Component, OnInit } from '@angular/core';
import { SlagalicaService } from './slagalica.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  numOfLetters: number = 12;
  letters: any = [];
  words: any = [];

  constructor(private service: SlagalicaService){}

  ngOnInit(): void {
    for(let i = 0; i < this.numOfLetters; i++){
      this.letters.push({letter: ""});
    }
  }

  findWords(): void {
    let letters = this.letters.map((x: { letter: any; }) => x.letter.toLowerCase()); 
    letters = letters.join(",");
    this.service.getWords(letters).subscribe((data: any) => this.words = data);
  }
}
