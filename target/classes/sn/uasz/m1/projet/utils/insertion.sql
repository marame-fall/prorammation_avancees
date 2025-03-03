-- Insertion de 5 utilisateurs dans la table Utilisateur
-- Utilisateurs de type Etudiant avec discrimination par la colonne 'role'

INSERT INTO Utilisateur (prenom, nom, email, sexe, motDePasse, role, ine, dateNaissance, groupeTd, groupeTp) 
VALUES ('a', 'a', 'a', 'F', 'a', 'Etudiant', 'INE12345', '2000-05-15', 1, 2);

INSERT INTO Utilisateur (prenom, nom, email, sexe, motDePasse, role,dateNaissance,  groupeTd, groupeTp, matricule) 
VALUES ('Fatou', 'Diallo', 'diallo@.uasz.sn', 'F', 'passer123', 'Responsable','1999-11-10', 'null','null','1001');

INSERT INTO Utilisateur (prenom, nom, email, sexe, motDePasse, role, ine, dateNaissance, groupeTd, groupeTp) 
VALUES ('Moussa', 'Ndiaye', 'moussa.ndiaye@etudiant.uasz.sn', 'M', 'password456', 'Etudiant', 'INE67890', '2001-03-22', 1, 3);

INSERT INTO Utilisateur (prenom, nom, email, sexe, motDePasse, role, ine, dateNaissance, groupeTd, groupeTp) 
VALUES ('Aminata', 'Fall', 'aminata.fall@etudiant.uasz.sn', 'F', 'password789', 'Etudiant', 'INE23456', '1999-11-10', 2, 1);

INSERT INTO Utilisateur (prenom, nom, email, sexe, motDePasse, role, ine, dateNaissance, groupeTd, groupeTp) 
VALUES ('Ibrahima', 'Sow', 'ibrahima.sow@etudiant.uasz.sn', 'M', 'passwordabc', 'Etudiant', 'INE34567', '2002-07-05', 2, 2);

INSERT INTO Utilisateur (prenom, nom, email, sexe, motDePasse, role, ine, dateNaissance, groupeTd, groupeTp) 
VALUES ('Mariama', 'Camara', 'mariama.camara@etudiant.uasz.sn', 'F', 'passworddef', 'Etudiant', 'INE45678', '2001-09-18', 3, 3);

INSERT INTO Utilisateur (prenom, nom, email, sexe, motDePasse, role,dateNaissance,  groupeTd, groupeTp, matricule) 
VALUES ('Fatou', 'fall', 'fall@uasz.sn', 'F', 'fall', 'Responsable','1999-11-10', 'null','null','1001');