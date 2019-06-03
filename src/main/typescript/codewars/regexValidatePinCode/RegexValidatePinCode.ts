export class Kata {
    static validatePin(pin: string): boolean {
    const fourDigits: RegExp = /^\d{4}$/
    const sixDigits: RegExp = /^\d{6}$/
    return fourDigits.test(pin) || sixDigits.test(pin)
  }
}


///
export class Kata {
  static pinFormat: RegExp = new RegExp(/^\d{4}(\d{2})?$/);

  static validatePin(pin: string): boolean {
    return Kata.pinFormat.test(pin);
  }
}


///
export class Kata {
  static validatePin(pin: string): boolean {
    const validRegex = new RegExp('^(\\d{4}|\\d{6})$');
    return validRegex.test(pin);
  }
}