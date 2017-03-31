# ORF-Finder-Projectgroep-10
Synopsis: 

Dit project is een programma dat ORF regions vindt in sequenties.
Er kan een sequentie opgegeven worden door de gebruiker, deze wordt gecontroleerd en er wordt gezocht naar ORF regions.
Ook kan er aangegeven hoelang de ORF mag zijn.


Motivation:

De rede voor het schrijven van dit programma is om ervoor te zorgen dat het mogelijk wordt het zoeken naar ORF's te automatiseren.
Het zoeken naar ORF's wordt hierdoor preciezer en stukken sneller.

Installation:

Het is van belang dat er voor dit project de library MySQL JDBC Driver geinstalleerd is.
Voor dit programma is het alleen nodig het script te clonen.

Tests:

De code kan getest worden door een fasta bestand te maken en hier verschillende sequenties in op te slaan.

Afwijkingen of aanpassingen vanaf het ontwerp:

Er is tijdens dit project gekozen voor het weglaten van een visualisatie van de data. Dit komt doordat de text area met statistieken
volgens ons voldoende was om de gebruiker te informeren over de resultaten.
Ook is ervoor gekozen geen BLASTs uit te voeren of te exporteren naar de database omdat de verbinding tussen ons script en NCBI BLAST
niet soepel verliep en het script heel erg vertraagde. Ook hebben we hier niet meer onderzoek naar kunnen doen door een gebrek aan tijd,
er is voor gekozen ons te focussen op het optimaliseren van de rest van het programma.
