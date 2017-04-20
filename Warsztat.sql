
CREATE TABLE Wlasciciel_Pojazdu (
  Id_Wlasciciela Integer NOT NULL,
  Imie Varchar2(30 ) NOT NULL,
  Nazwisko Varchar2(30 ) NOT NULL,
  Miasto Varchar2(30 ) NOT NULL,
  Ulica Varchar2(30 ) NOT NULL,
  Nr_Budynku Number NOT NULL,
  Nr_Mieszkania Number,
  Nr_telefonu Varchar2(30 ),
  Adres_email Varchar2(30 ),
  Staly_klient Varchar2(30 ) NOT NULL
)
/

ALTER TABLE Wlasciciel_Pojazdu ADD CONSTRAINT Key1 PRIMARY KEY ( Id_Wlasciciela )

CREATE TABLE Pojazd (
  Id_pojazdu Integer NOT NULL,
  Id_Wlasciciela Integer NOT NULL,
  Id_Modelu Integer NOT NULL,
  Nr_rejestracyjny Varchar2(30 ) NOT NULL,
  Rok_produkcji Number NOT NULL,
  Przebieg Number NOT NULL
)

CREATE INDEX IX_Relationship2 ON Pojazd ( Id_Wlasciciela )


CREATE INDEX IX_Relationship3 ON Pojazd ( Id_Modelu )

ALTER TABLE Pojazd ADD CONSTRAINT Key2 PRIMARY KEY ( Id_pojazdu )

CREATE TABLE Model (
  Id_Modelu Integer NOT NULL,
  Nazwa_modelu Varchar2(30 ) NOT NULL,
  Marka Varchar2(30 ) NOT NULL
)

ALTER TABLE Model ADD CONSTRAINT Key4 PRIMARY KEY ( Id_Modelu )

CREATE TABLE Pozycja_Planu_Serwisowego (
  Id_pozycji_planu_serwisowego Integer NOT NULL,
  Id_Modelu Integer NOT NULL
)

CREATE INDEX IX_Relationship11 ON Pozycja_Planu_Serwisowego ( Id_Modelu )

ALTER TABLE Pozycja_Planu_Serwisowego ADD CONSTRAINT Key5 PRIMARY KEY ( Id_pozycji_planu_serwisowego )

CREATE TABLE Naprawa (
  Id_naprawy Integer NOT NULL,
  Id_pojazdu Integer NOT NULL
)

CREATE INDEX IX_Relationship30 ON Naprawa ( Id_pojazdu )

ALTER TABLE Naprawa ADD CONSTRAINT Key6 PRIMARY KEY ( Id_naprawy )

CREATE TABLE Przeglad (
  Id_przegladu Integer NOT NULL,
  Id_pojazdu Integer NOT NULL
)

CREATE INDEX IX_Relationship33 ON Przeglad ( Id_pojazdu )

ALTER TABLE Przeglad ADD CONSTRAINT Key7 PRIMARY KEY ( Id_przegladu )

CREATE TABLE Wykonanie_Operacji (
  Id_wykonania_operacji Integer NOT NULL,
  Id_przegladu Integer NOT NULL,
  Id_naprawy Integer NOT NULL,
  Id_operacji Integer NOT NULL,
  Id_stanowiska Integer NOT NULL
)

CREATE INDEX IX_Relationship34 ON Wykonanie_Operacji ( Id_przegladu )

CREATE INDEX IX_Relationship31 ON Wykonanie_Operacji ( Id_naprawy )

CREATE INDEX IX_Relationship9 ON Wykonanie_Operacji ( Id_operacji )

CREATE INDEX IX_Relationship35 ON Wykonanie_Operacji ( Id_stanowiska )

ALTER TABLE Wykonanie_Operacji ADD CONSTRAINT Key8 PRIMARY KEY ( Id_wykonania_operacji )

CREATE TABLE Przydzial_Pracownika (
  Id_pracownika Integer NOT NULL,
  Id_wykonania_operacji Integer NOT NULL
)

ALTER TABLE Przydzial_Pracownika ADD CONSTRAINT Key9 PRIMARY KEY ( Id_pracownika , Id_wykonania_operacji )

CREATE TABLE Pracownik (
  Id_pracownika Integer NOT NULL,
  Imie Varchar2(30 ) NOT NULL,
  Nazwisko Varchar2(30 ) NOT NULL,
  Nr_telefonu Number NOT NULL
)
/

-- Add keys for table Pracownik

ALTER TABLE Pracownik ADD CONSTRAINT Id_Pracownika PRIMARY KEY ( Id_pracownika )
/

-- Table Dostêpnoœc Czêsci

CREATE TABLE Dostepnosc_Czesci (
  Id_dostawcy Integer NOT NULL,
  Id_czesci Integer NOT NULL
)
/

-- Add keys for table Dostêpnoœc Czêsci

ALTER TABLE Dostepnosc_Czesci ADD CONSTRAINT Key11 PRIMARY KEY ( Id_dostawcy , Id_czesci )
/

-- Table Zamówiona Czêœc

CREATE TABLE Zamowiona_Czesc (
  Id_zamowionej_czesci Integer NOT NULL,
  Id_dostawy Integer NOT NULL,
  Id_czesci Integer NOT NULL
)
/

-- Create indexes for table Zamówiona Czêœc

CREATE INDEX IX_Relationship28 ON Zamowiona_Czesc ( Id_dostawy )
/

CREATE INDEX IX_Relationship27 ON Zamowiona_Czesc ( Id_czesci )
/

-- Add keys for table Zamówiona Czêœc

ALTER TABLE Zamowiona_Czesc ADD CONSTRAINT Key12 PRIMARY KEY ( Id_zamowionej_czesci )
/

-- Table Stanowisko

CREATE TABLE Stanowisko (
  Id_stanowiska Integer NOT NULL,
  Id_typu_stanowiska Integer NOT NULL,
  Nr_stanowiska Number NOT NULL,
  Nazwa_stanowiska Varchar2(30 ) NOT NULL
)
/

-- Create indexes for table Stanowisko

CREATE INDEX IX_Relationship16 ON Stanowisko ( Id_typu_stanowiska )
/

-- Add keys for table Stanowisko

ALTER TABLE Stanowisko ADD CONSTRAINT Key13 PRIMARY KEY ( Id_stanowiska )
/

-- Table Typ Stanowiska

CREATE TABLE Typ_Stanowiska (
  Id_typu_stanowiska Integer NOT NULL,
  Nazwa_typu Number NOT NULL
)
/

-- Add keys for table Typ Stanowiska

ALTER TABLE Typ_Stanowiska ADD CONSTRAINT Key14 PRIMARY KEY ( Id_typu_stanowiska )
/

-- Table Przydzia³ Czêœci

CREATE TABLE Przydzial_Czesci (
  Id_wykonania_operacji Integer NOT NULL,
  Id_czesci Integer NOT NULL
)
/

-- Add keys for table Przydzia³ Czêœci

ALTER TABLE Przydzial_Czesci ADD CONSTRAINT Key15 PRIMARY KEY ( Id_wykonania_operacji , Id_czesci )
/

-- Table Operacja

CREATE TABLE Operacja (
  Id_operacji Integer NOT NULL,
  Id_typu_stanowiska Integer NOT NULL,
  Nazwa Varchar2(30 ) NOT NULL,
  Czas_trwania Number NOT NULL
)
/

-- Create indexes for table Operacja

CREATE INDEX IX_Relationship18 ON Operacja ( Id_typu_stanowiska )
/

-- Add keys for table Operacja

ALTER TABLE Operacja ADD CONSTRAINT Key16 PRIMARY KEY ( Id_operacji )
/

-- Table Czesc

CREATE TABLE Czesc (
  Id_czesci Integer NOT NULL,
  Id_operacji Integer NOT NULL,
  Nazwa Varchar2(30 ),
  Nr_seryjny Varchar2(30 ),
  Ilosc_czesci Number NOT NULL
)
/

-- Create indexes for table Czesc

CREATE INDEX IX_Relationship23 ON Czesc ( Id_operacji )
/

-- Add keys for table Czesc

ALTER TABLE Czesc ADD CONSTRAINT Key17 PRIMARY KEY ( Id_czesci )
/

-- Table Typ_Urzadzenia

CREATE TABLE Typ_Urzadzenia (
  Id_typu_urzadzenia Integer NOT NULL,
  Id_operacji Integer NOT NULL,
  Nazwa Varchar2(30 ) NOT NULL
)
/

-- Create indexes for table Typ_Urzadzenia

CREATE INDEX IX_Relationship21 ON Typ_Urzadzenia ( Id_operacji )
/

-- Add keys for table Typ_Urzadzenia

ALTER TABLE Typ_Urzadzenia ADD CONSTRAINT Key18 PRIMARY KEY ( Id_typu_urzadzenia )
/

-- Table Operacja Serwisowa

CREATE TABLE Operacja_Serwisowa (
  Id_pozycji_planu_serwisowego Integer NOT NULL,
  Id_operacji Integer NOT NULL
)
/

-- Add keys for table Operacja Serwisowa

ALTER TABLE Operacja_Serwisowa ADD CONSTRAINT Key19 PRIMARY KEY ( Id_pozycji_planu_serwisowego , Id_operacji )
/

-- Table Pozycja Grafiku

CREATE TABLE Pozycja_Grafiku (
  Id_pozycji_grafiku Integer NOT NULL,
  Id_pracownika Integer NOT NULL,
  Poniedzialek Number,
  Wtorek Number,
  Sroda Number,
  Czwartek Number,
  Piatek Number,
  Sobota Number
)
/

-- Create indexes for table Pozycja Grafiku

CREATE INDEX IX_Relationship14 ON Pozycja_Grafiku ( Id_pracownika )
/

-- Add keys for table Pozycja Grafiku

ALTER TABLE Pozycja_Grafiku ADD CONSTRAINT Key20 PRIMARY KEY ( Id_pozycji_grafiku )
/

-- Table Pozycja Wyposazenia

CREATE TABLE Pozycja_Wyposazenia (
  Id_pozycji_wyposazenia Integer NOT NULL,
  Id_typu_stanowiska Integer NOT NULL,
  Stan Varchar2(30 ) NOT NULL
)
/

-- Create indexes for table Pozycja Wyposazenia

CREATE INDEX IX_Relationship17 ON Pozycja_Wyposazenia ( Id_typu_stanowiska )
/

-- Add keys for table Pozycja Wyposazenia

ALTER TABLE Pozycja_Wyposazenia ADD CONSTRAINT Key21 PRIMARY KEY ( Id_pozycji_wyposazenia )
/

-- Table Dostawca

CREATE TABLE Dostawca (
  Id_dostawcy Integer NOT NULL,
  Nazwa_dostawcy Varchar2(30 ) NOT NULL,
  Nr_telefonu Varchar2(30 ),
  E-mail Varchar2(30 )
)
/

-- Add keys for table Dostawca

ALTER TABLE Dostawca ADD CONSTRAINT Key22 PRIMARY KEY ( Id_dostawcy )
/

-- Table Urzadzenie

CREATE TABLE Urzadzenie (
  Id_urzadzenia Integer NOT NULL,
  Id_typu_urzadzenia Integer NOT NULL,
  Nazwa_urzadzenia Varchar2(30 ) NOT NULL,
  Nr_seryjny_urzadzenia Varchar2(30 ) NOT NULL
)
/

-- Create indexes for table Urzadzenie

CREATE INDEX IX_Relationship22 ON Urzadzenie ( Id_typu_urzadzenia )
/

-- Add keys for table Urzadzenie

ALTER TABLE Urzadzenie ADD CONSTRAINT Key23 PRIMARY KEY ( Id_urzadzenia )
/

-- Table Dostawa

CREATE TABLE Dostawa (
  Id_dostawy Integer NOT NULL,
  Id_dostawcy Integer NOT NULL,
  Numer_dostawy Number NOT NULL,
  Sposob_dostawy Varchar2(30 ) NOT NULL,
  Termin_realizacji Date NOT NULL
)
/

-- Create indexes for table Dostawa

CREATE INDEX IX_Relationship26 ON Dostawa ( Id_dostawcy )
/

-- Add keys for table Dostawa

ALTER TABLE Dostawa ADD CONSTRAINT Key24 PRIMARY KEY ( Id_dostawy )
/

-- Create relationships section ------------------------------------------------- 

ALTER TABLE Pojazd ADD CONSTRAINT Relationship2 FOREIGN KEY ( Id_Wlasciciela ) REFERENCES Wlasciciel_Pojazdu ( Id_Wlasciciela )
/

ALTER TABLE Pojazd ADD CONSTRAINT Relationship3 FOREIGN KEY ( Id_Modelu ) REFERENCES Model ( Id_Modelu )
/

ALTER TABLE Wykonanie_Operacji ADD CONSTRAINT Relationship9 FOREIGN KEY ( Id_operacji ) REFERENCES Operacja ( Id_operacji )
/

ALTER TABLE Przydzial_Czesci ADD CONSTRAINT Relationship10 FOREIGN KEY ( Id_wykonania_operacji ) REFERENCES Wykonanie_Operacji ( Id_wykonania_operacji )
/

ALTER TABLE Pozycja_Planu_Serwisowego ADD CONSTRAINT Relationship11 FOREIGN KEY ( Id_Modelu ) REFERENCES Model ( Id_Modelu )
/

ALTER TABLE Przydzial_Pracownika ADD CONSTRAINT Relationship12 FOREIGN KEY ( Id_wykonania_operacji ) REFERENCES Wykonanie_Operacji ( Id_wykonania_operacji )
/

ALTER TABLE Przydzial_Pracownika ADD CONSTRAINT Relationship13 FOREIGN KEY ( Id_pracownika ) REFERENCES Pracownik ( Id_pracownika )
/

ALTER TABLE Pozycja_Grafiku ADD CONSTRAINT Relationship14 FOREIGN KEY ( Id_pracownika ) REFERENCES Pracownik ( Id_pracownika )
/

ALTER TABLE Stanowisko ADD CONSTRAINT Relationship16 FOREIGN KEY ( Id_typu_stanowiska ) REFERENCES Typ_Stanowiska ( Id_typu_stanowiska )
/

ALTER TABLE Pozycja_Wyposazenia ADD CONSTRAINT Relationship17 FOREIGN KEY ( Id_typu_stanowiska ) REFERENCES Typ_Stanowiska ( Id_typu_stanowiska )
/

ALTER TABLE Operacja ADD CONSTRAINT Relationship18 FOREIGN KEY ( Id_typu_stanowiska ) REFERENCES Typ_Stanowiska ( Id_typu_stanowiska )
/

ALTER TABLE Operacja_Serwisowa ADD CONSTRAINT Relationship19 FOREIGN KEY ( Id_operacji ) REFERENCES Operacja ( Id_operacji )
/

ALTER TABLE Operacja_Serwisowa ADD CONSTRAINT Relationship20 FOREIGN KEY ( Id_pozycji_planu_serwisowego ) REFERENCES Pozycja_Planu_Serwisowego ( Id_pozycji_planu_serwisowego )
/

ALTER TABLE Typ_Urzadzenia ADD CONSTRAINT Relationship21 FOREIGN KEY ( Id_operacji ) REFERENCES Operacja ( Id_operacji )
/

ALTER TABLE Urzadzenie ADD CONSTRAINT Relationship22 FOREIGN KEY ( Id_typu_urzadzenia ) REFERENCES Typ_Urzadzenia ( Id_typu_urzadzenia )
/

ALTER TABLE Czesc ADD CONSTRAINT Relationship23 FOREIGN KEY ( Id_operacji ) REFERENCES Operacja ( Id_operacji )
/

ALTER TABLE Dostepnosc_Czesci ADD CONSTRAINT Relationship24 FOREIGN KEY ( Id_czesci ) REFERENCES Czesc ( Id_czesci )
/

ALTER TABLE Dostepnosc_Czesci ADD CONSTRAINT Relationship25 FOREIGN KEY ( Id_dostawcy ) REFERENCES Dostawca ( Id_dostawcy )
/

ALTER TABLE Dostawa ADD CONSTRAINT Relationship26 FOREIGN KEY ( Id_dostawcy ) REFERENCES Dostawca ( Id_dostawcy )
/

ALTER TABLE Zamowiona_Czesc ADD CONSTRAINT Relationship27 FOREIGN KEY ( Id_czesci ) REFERENCES Czesc ( Id_czesci )
/

ALTER TABLE Zamowiona_Czesc ADD CONSTRAINT Relationship28 FOREIGN KEY ( Id_dostawy ) REFERENCES Dostawa ( Id_dostawy )
/

ALTER TABLE Przydzial_Czesci ADD CONSTRAINT Relationship29 FOREIGN KEY ( Id_czesci ) REFERENCES Czesc ( Id_czesci )
/

ALTER TABLE Naprawa ADD CONSTRAINT Relationship30 FOREIGN KEY ( Id_pojazdu ) REFERENCES Pojazd ( Id_pojazdu )
/

ALTER TABLE Wykonanie_Operacji ADD CONSTRAINT Relationship31 FOREIGN KEY ( Id_naprawy ) REFERENCES Naprawa ( Id_naprawy )
/

ALTER TABLE Przeglad ADD CONSTRAINT Relationship33 FOREIGN KEY ( Id_pojazdu ) REFERENCES Pojazd ( Id_pojazdu )
/

ALTER TABLE Wykonanie_Operacji ADD CONSTRAINT Relationship34 FOREIGN KEY ( Id_przegladu ) REFERENCES Przeglad ( Id_przegladu )
/

ALTER TABLE Wykonanie_Operacji ADD CONSTRAINT Relationship35 FOREIGN KEY ( Id_stanowiska ) REFERENCES Stanowisko ( Id_stanowiska )
/



