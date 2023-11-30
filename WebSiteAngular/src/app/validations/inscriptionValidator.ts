import { AbstractControl, ValidationErrors } from "@angular/forms";

export class InscriptionValidator{
    public static usernamePasswordDifferent(control:AbstractControl):ValidationErrors | null{
        return control.get('username')?.value == control.get('groupPassword.password')?.value ? {usernamePasswordEquals:true} : null;
    }

    public static passwordConfirmer(control:AbstractControl):ValidationErrors | null{
        return control.get('groupPassword.password')?.value == control.get('groupPassword.password2')?.value ?{passwordDifferent:true} : null;
    }

}
