# MoltenSmith

> Un mod realista de forja de armas con sistema modular para Minecraft 1.21.1 (NeoForge)

## 📖 Descripción

**MoltenSmith** es un mod que transforma el sistema de herramientas de Minecraft en una experiencia de herrería inmersiva y realista. Derrite metales en una fundición multibloque, crea partes personalizadas y ensambla armas únicas con estadísticas balanceadas.

### ✨ Características Principales

- 🔥 **Sistema de Fundición** - Estructura multibloque para derretir lingotes en metal líquido
- ⚔️ **Armas Modulares Optimizadas** - 10 tipos de armas con sistema de partes reutilizables
- 🔧 **5 Partes Comodín** - Vara, Asta, Ligadura, Guarda y Pomo se usan en múltiples armas
- 🎯 **Compatible con Better Combat** - Integración completa con mecánicas de combate mejoradas
- ⚖️ **Sistema de Trade-offs** - Cada material tiene ventajas y desventajas balanceadas
- 🛠️ **10 Materiales** - Desde madera hasta netherite, cada uno con propiedades únicas
- 👥 **Ideal para Roleplay** - Perfecto para servidores con herreros que vendan armas
- 📦 **Eficiencia de Assets** - Solo 12 moldes necesarios gracias a la reutilización inteligente

### 🗡️ Armas Disponibles

| Arma | Receta (Partes) | Característica |
|------|----------------|----------------|
| **Daga** | Hoja de Cuchillo + Guarda + Vara | Rápida, corto alcance |
| **Espada** | Hoja de Espada + Guarda + Vara + Pomo | Balanceada, versátil |
| **Claymore** | *Misma Hoja* + Guarda + **Asta** + Pomo | Alto daño, dos manos |
| **Katana** | Hoja de Katana + Ligadura + Vara | Velocidad alta, durabilidad baja |
| **Lanza** | Punta de Lanza + Asta + Pomo | Máximo alcance |
| **Hacha** | Cabeza de Hacha + Vara + Ligadura | Alto daño, lenta |
| **Alabarda** | *Misma Cabeza* + **Asta** + Ligadura | Hacha de dos manos |
| **Pico** | Cabeza de Pico + Vara + Ligadura | Minería especializada |
| **Pala** | Placa Grande + Asta + Ligadura | Tierra/arena |
| **Azada** | Cabeza modificada + Vara | Herramienta agrícola |

**💡 Innovación**: La misma Hoja de Espada sirve para Espada (una mano) y Claymore (dos manos) cambiando solo el mango. ¡Máxima reutilización!

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

- [📋 Plan de Desarrollo Completo](docs/PLANNING.md) - 8 fases de desarrollo
- [✅ Fase 1 Completada](docs/FASE1_COMPLETADA.md) - Sistema de materiales
- [🔧 **NUEVO**: Sistema de Partes Optimizado](docs/SISTEMA_PARTES_OPTIMIZADO.md) - Explicación detallada de las partes reutilizables
- [🎨 Información de Texturas](docs/TEXTURAS_INFO.md) - ~172 texturas necesarias

## 🎨 Contribuir

¡Las contribuciones son bienvenidas! Especialmente:
- 🎨 **Artistas** - Necesitamos ~172 texturas (ver [TEXTURAS_INFO.md](docs/TEXTURAS_INFO.md))
  - 120 texturas de partes (12 tipos × 10 materiales)
  - 14 moldes
  - 20 fluidos
  - 10 bloques
  - 8 GUIs
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
