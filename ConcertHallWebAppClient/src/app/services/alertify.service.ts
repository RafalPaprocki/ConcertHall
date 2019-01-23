import { Injectable } from '@angular/core';
// we have to add this even it available globally
declare let alertify: any;

@Injectable({
  providedIn: 'root'
})
export class AlertifyService {

constructor() { }

confirm(message: string, ok: () => any) {
  alertify.confirm(message, function(e) {
    if (e) {
      ok();
    } else {}
  });
}

success(message: string) {
  alertify.success(message);
}

error(message: string) {
  alertify.error(message);
}

warning(message: string) {
  alertify.warning(message);
}

message(message: string) {
  alertify.message(message);
}

}
