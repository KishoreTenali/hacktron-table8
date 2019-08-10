import { Component, OnInit } from '@angular/core';

export interface Queue {
  name: string;
  size: number;
}

const ELEMENT_DATA: Queue[] = [
  { name: 'Queue 1', size: 10},
  { name: 'Queue 2', size: 20},
  { name: 'Queue 3', size: 20},
  { name: 'Queue 4', size: 20},
  { name: 'Queue 5', size: 20},
  { name: 'Queue 6', size: 20},
 
];


@Component({
  selector: 'app-list-view',
  templateUrl: './list-view.component.html',
  styleUrls: ['./list-view.component.css']
})
export class ListViewComponent implements OnInit {

  displayedColumns: string[] = ['name', 'size'];
  dataSource = ELEMENT_DATA;

  constructor() { }

  ngOnInit() {
  }

}
