int g_pin = 4;
int b_pin = 5;
int r_pin = 6;

int green = 8;
int yellow = 9;
int red = 10;

bool rgb = true;


void setup() {
  pinMode(yellow, OUTPUT);
  pinMode(green, OUTPUT);
  pinMode(red, OUTPUT);
  pinMode(b_pin, OUTPUT);
  pinMode(g_pin, OUTPUT);
  pinMode(r_pin, OUTPUT);
  analogWrite(r_pin, 0);
  analogWrite(b_pin, 0);
  analogWrite(g_pin, 0);
}

void loop() {
  if (!rgb) {
    digitalWrite(red, 1);
    digitalWrite(yellow, 0);
    digitalWrite(green, 0);
  } else {
    analogWrite(r_pin, 255);
    analogWrite(b_pin, 0);
    analogWrite(g_pin, 0);
  }

  delay(5000);

  if (!rgb) {
    digitalWrite(red, 0);
    digitalWrite(yellow, 1);
    digitalWrite(green, 0);
  } else {
    analogWrite(r_pin, 255);
    analogWrite(b_pin, 0);
    analogWrite(g_pin, 255);
  }

  delay(1500);

  if (!rgb) {
    digitalWrite(red, 0);
    digitalWrite(yellow, 0);
    digitalWrite(green, 1);
  } else {
    analogWrite(r_pin, 0);
    analogWrite(b_pin, 0);
    analogWrite(g_pin, 255);
  }
  delay(2500);
}