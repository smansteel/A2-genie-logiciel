import { Component, Input, OnInit } from "@angular/core";
import { Skill } from "../../types/Skill.enum";
import { CommonModule } from "@angular/common";

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

  ngOnInit(): void {
    console.log(this.skill);
  }

  toggleEdit() {
    if (!this.isEditable) return;

    this.isExpanded = !this.isExpanded;
  }
}
