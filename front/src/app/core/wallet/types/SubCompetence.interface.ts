import { Skill } from "./Skill.enum";

export interface SubCompetence {
  id: number;
  name: string;
  description: string;
  skill: Skill;
}
