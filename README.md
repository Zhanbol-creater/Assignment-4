# Assignment-4
# 🎵 Music Library CLI System

- **Single Responsibility** → Each class has one clear responsibility.  
- **Open/Closed** → Extendable for new media types without modifying core logic.  
- **Liskov Substitution** → `Song` and `Podcast` inherit from `MediaBase` correctly.  
- **Interface Segregation** → `SongServiceInterface` focuses only on song-related methods.  
- **Dependency Inversion** → Services depend on repository interfaces, not concrete classes.  


---

## 🧠 SOLID Principles Applied

- **Single Responsibility** → Each class has one clear responsibility.  
- **Open/Closed** → Extendable for new media types without modifying core logic.  
- **Liskov Substitution** → `Song` and `Podcast` inherit from `MediaBase` correctly.  
- **Interface Segregation** → `SongServiceInterface` focuses only on song-related methods.  
- **Dependency Inversion** → Services depend on repository interfaces, not concrete classes.  



## 🧪 Test Scenarios

-  Add Song → inserts into `songs` table  
-  Add Podcast → inserts into `podcasts` table  
-  Create Playlist → inserts into `playlists` and `playlist_media`  
-  Invalid input → triggers `InvalidInputException`  
-  List operations → fetch and display from DB  

---

## 🧩 Features

- Generics (`CrudRepository<T>`)  
- Reflection (`ReflectionUtils`)  
- Lambda expressions (`SortingUtils`)  
- Exception handling  
- JDBC + PostgreSQL integration  

---

## 🖼️ Screenshots

Stored in `docs/screenshots/`:  
- CLI menu  
- Song/Podcast creation  
- Playlist linking  
- Error handling  

---

## 📚 Reflection

Through this project I learned:  
- How to structure a layered Java application.  
- How to apply SOLID principles in practice.  
- How to integrate JDBC with PostgreSQL.  
- How to design UML and ER diagrams for real-world systems.  


