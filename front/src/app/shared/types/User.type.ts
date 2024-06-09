import { Roles } from "./Role.enum";

export interface User {
  id: number;
  username: string;
  firstName: string;
  name: string;
  role?: Roles;
}
