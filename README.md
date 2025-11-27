# MoltenSmith

> Un mod realista de forja de armas con sistema modular para Minecraft 1.21.1 (NeoForge)

## 📖 Descripción

**MoltenSmith** es un mod que transforma el sistema de herramientas de Minecraft en una experiencia de herrería inmersiva y realista. Derrite metales en una fundición multibloque, crea partes personalizadas y ensambla armas únicas con estadísticas balanceadas.

### ✨ Características Principales

- 🔥 **Sistema de Fundición** - Estructura multibloque para derretir lingotes en metal líquido
- ⚔️ **Armas Modulares** - 8 tipos de armas con partes intercambiables
- 🎯 **Compatible con Better Combat** - Integración completa con mecánicas de combate mejoradas
- ⚖️ **Sistema de Trade-offs** - Cada material tiene ventajas y desventajas balanceadas
- 🛠️ **10 Materiales** - Desde madera hasta netherite, cada uno con propiedades únicas
- 👥 **Ideal para Roleplay** - Perfecto para servidores con herreros que vendan armas

### 🗡️ Armas Disponibles

1. **Daga** - Rápida, corto alcance
2. **Espada** - Balanceada, versátil
3. **Espada Larga / Claymore** - Alto daño, dos manos, lenta
4. **Katana** - Velocidad media-alta, estilo japonés
5. **Lanza** - Máximo alcance, daño moderado
6. **Hacha** - Alto daño por golpe, lenta
7. **Pico** - Herramienta de minería
8. **Azada** - Herramienta/arma versátil

## 🎮 Estado del Desarrollo

**Fase 1: Completada ✅**
- [x] Sistema de materiales implementado
- [x] 10 materiales balanceados
- [x] Estructura de proyecto configurada
- [x] Mod funcional y testado

**Fase 2: En Desarrollo 🚧**
- [ ] Items de partes de armas
- [ ] Bloques de fundición
- [ ] Sistema de fundición funcional
- [ ] Moldes y casting

**Fase 3+: Planeada 📋**
- [ ] Tool Station y ensamblaje
- [ ] Sistema de modificadores
- [ ] Texturas personalizadas
- [ ] Compatibilidad Better Combat

## 📦 Instalación

### Requisitos
- Minecraft 1.21.1
- NeoForge 21.1.215+
- Java 21

### Pasos
1. Descarga el archivo `.jar` del mod
2. Colócalo en la carpeta `mods/` de tu instalación de Minecraft
3. Inicia el juego con el perfil de NeoForge

## 🔨 Desarrollo

### Para Desarrolladores

```bash
# Clonar el repositorio
git clone https://github.com/Paulo652/MDK-1.21.1-ModDevGradle.git
cd MDK-1.21.1-ModDevGradle

# Compilar el mod
.\gradlew build

# Ejecutar cliente de prueba
.\gradlew runClient
```

### Estructura del Proyecto
```
src/main/java/com/paulo/moltensmith/
├── materials/          # Sistema de materiales
├── items/             # Partes y armas
├── blocks/            # Bloques de fundición
├── gui/               # Interfaces gráficas
├── data/              # Recetas y datos
└── integration/       # Compatibilidad con otros mods
```

## 📚 Documentación

- [Plan de Desarrollo Completo](docs/PLANNING.md)
- [Fase 1 Completada](docs/FASE1_COMPLETADA.md)
- [Información de Texturas](docs/TEXTURAS_INFO.md)

## 🎨 Contribuir

¡Las contribuciones son bienvenidas! Especialmente:
- 🎨 **Artistas** - Necesitamos ~190 texturas (ver [TEXTURAS_INFO.md](docs/TEXTURAS_INFO.md))
- 💻 **Programadores** - Ayuda con mecánicas y features
- 🌍 **Traductores** - Traducciones a otros idiomas
- 🐛 **Testers** - Reportar bugs y sugerencias

## 📝 Licencia

Este proyecto está bajo la licencia MIT. Ver [TEMPLATE_LICENSE.txt](TEMPLATE_LICENSE.txt) para más detalles.

## 👤 Autor

**Paulo652**
- GitHub: [@Paulo652](https://github.com/Paulo652)

## 🙏 Agradecimientos

- NeoForge Team por el framework
- Tinkers' Construct por la inspiración
- Better Combat por la compatibilidad

---

**Estado**: 🚧 En Desarrollo Activo | **Versión**: 0.1.0-alpha

---

## Additional Resources

Community Documentation: https://docs.neoforged.net/  
NeoForged Discord: https://discord.neoforged.net/
