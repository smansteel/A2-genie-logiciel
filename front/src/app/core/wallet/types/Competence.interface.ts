import { SubCompetence } from "./SubCompetence.interface";

export interface Competence {
  id: number;
  name: string;
  description: string;
  subCompetencies : SubCompetence[]
}
