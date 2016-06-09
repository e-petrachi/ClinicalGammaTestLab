# gammaTestLab
Project for the course of SIW in 06/2016

Course of Degree in Computer Engineering

Developer: Enrico Petrachi & Marco Zebi 

Used technologies: 
- JAVA
- JEE + EJB
- JPA : Hibernate
- JSP
- JSF
- JSTL
- jQuery
- HTML5 + XHTML
- CSS3 + PureCSS
- XML + DTD
- SQL + JPQL 
- PostgreSQL + JDBC
- Apache Maven
- Apache TomEE
- Eclipse
- Git

Description:

Si vuole realizzare un sistema informativo su Web per la prenotazione degli esami medici di una piccola clinica.
Oltre agli utenti occasionali, due tipologie di attori interagiscono con il sistema: i pazienti e l'amministrazione

Un utente occasionale può svolgere le seguenti operazioni:
	
	1.Consultare l'elenco delle tipologie di esame
	2.Scegliere una tipologia di esame e richiederne i dettagli 
	
Un paziente può svolgere le seguenti operazioni (non implementate graficamente):
	
	1.Consultazione tipologie di esami offerti dalle clinica
	2.Consultazione dei risultati di un proprio esame

L'amministrazione può svolgere le seguenti operazioni:
	
	1.Inserimento di una tipologia di esame 
	2.Inserimento di un esame
	3.Inserimento di un paziente nella anagrafica pazienti
	4.Ricerca di tutti gli esami effettuati da un medico
	5.Inserimento risultati di un esame
	
	
Specifiche:


Per ogni tipologia di esame sono di interesse un nome, un codice, una descrizione, un costo. Ogni tipologia di esame ha inoltre un insieme di prerequisiti che sono rappresentati da un insieme coppie nome valore. Ogni tipologia di esame ha un insieme di indicatori per i risultati. Per ogni esame è necessario riportare, oltre al paziente, la data di prenotazione, la data in cui è stato effettuato l'esame ed il nome del medico che ha condotto l'esame. Per ogni medico è necessario gestire: nome, cognome, specializzazione. I risultati di un esame sono un insieme di coppie nome-valore. Ipotizziamo che i pagamenti vengano gestiti off-line



 

