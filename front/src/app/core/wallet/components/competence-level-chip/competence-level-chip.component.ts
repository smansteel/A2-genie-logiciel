import { Component, ElementRef, HostListener, Input, OnInit } from "@angular/core";
import { Skill } from "../../types/Skill.enum";
import { CommonModule, KeyValue } from "@angular/common";

@Component({
  selector: "app-competence-level-chip",
  standalone: true,
  imports: [CommonModule],
  templateUrl: "./competence-level-chip.component.html",
  styleUrl: "./competence-level-chip.component.css",
})
export class CompetenceLevelChipComponent implements OnInit {
  @Input({ required: true }) skill: Skill | null = null;
  @Input({ required: true }) isEditable: boolean = false;
  isExpanded: boolean = false;
  Skills = Skill;

  constructor(private _elementRef: ElementRef) {}

  customOrder = ["Au-delà", "Attendu", "Très Proche", "Proche", "Loin", "Non Validé"];
  customSort = (a: KeyValue<string, any>, b: KeyValue<string, any>): number => {
    return this.customOrder.indexOf(a.value.name) + this.customOrder.indexOf(b.value.name);
  };

  ngOnInit(): void {
    console.log(this.isEditable);
  }

  toggleEdit() {
    if (!this.isEditable) return;

    this.isExpanded = !this.isExpanded;
  }

  editCompetence(newSkill: Skill) {
    this.skill = newSkill;
  }

  @HostListener("document:click", ["$event"])
  onDocumentClick(event: MouseEvent) {
    const clickedInside = this._elementRef.nativeElement.contains(event.target);
    if (!clickedInside) {
      this.isExpanded = false;
    }
  }
}
