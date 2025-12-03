# MoltenSmith - "The Tactile Smithing Update"

**Versión**: Final v4.0  
**Fecha**: 2 Diciembre 2025  
**Objetivo**: Sistema de herrería inmersivo sin GUIs, basado en crafting físico en el mundo 3D

---

## 🎯 1. Filosofía del Proyecto

### "Construye tu taller, no solo craftees items"

#### Principios Core:
1. **🚫 Cero GUIs**: Todo es táctil - ves los items en el mundo, los manipulas directamente
2. **🏗️ Lógica Física**: Armas grandes necesitan mesas grandes, metal caliente quema, bloques se conectan
3. **🔨 Inmersión Total**: Usa herramientas reales (tenazas, martillo), siente cada paso del proceso
4. **📐 Modularidad**: Los bloques se combinan horizontalmente/verticalmente para diferentes capacidades

#### ¿Por qué es diferente?
- **vs Tinkers' Construct**: Sin fluidos, sin moldes, sin GUIs complicadas
- **vs Vanilla**: Proceso completo y realista, no solo crafteo instantáneo
- **vs Otros mods**: Visualización 3D real de cada etapa del proceso

---

## 🔄 2. El Ciclo de Herrería (The Core Loop)

### Proceso de creación en 5 fases:

```
📐 DRAFTING → 🔥 HEATING → 🔨 FORGING → 💧 QUENCHING → 🔧 ASSEMBLY
(Diseñar)    (Calentar)   (Forjar)     (Templar)      (Ensamblar)
```

### 📐 **Fase 0: DRAFTING (Diseño de Planos)**
**Objetivo**: Crear las plantillas técnicas necesarias para forjar

- **Dónde**: Drafting Station (Mesa de Delineante)
- **Input**: Template Base (papel en blanco) + Ink Sac (tinta)
- **Acción**: Seleccionar diseño del catálogo en la GUI
- **Resultado**: Template específico (ej. "Sword Blade Template")
- **Visual**: Libro abierto en la mesa, páginas pasando
- **Concepto**: "Consultar el Manual del Maestro Herrero"

### 🔥 **Fase 1: HEATING (Calentamiento)**
**Objetivo**: Calentar lingotes hasta que sean maleables

- **Dónde**: Ember Hearth (Fragua)
- **Input**: Lingotes fríos (iron ingot, gold ingot, etc.)
- **Acción**: Colocar en la fragua encendida
- **Resultado**: Lingotes calientes (rojo brillante)
- **Tiempo**: ~30-60 segundos
- **Estado visual**: Gris → Naranja → Rojo → Blanco incandescente

### 🔨 **Fase 2: FORGING (Forjado)**
**Objetivo**: Dar forma al metal caliente

- **Dónde**: Grand Anvil (Yunque)
- **Input**: Lingotes calientes (1-3 según la pieza) + Template (plantilla)
- **Acción**: Golpear con Martillo repetidamente
- **Resultado**: Hot Part (parte caliente con forma - ej. "Hot Sword Blade")
- **Progreso**: Barra visual o contador de golpes
- **Estado visual**: El metal se "deforma" hacia la forma de la plantilla

### 💧 **Fase 3: QUENCHING (Templado)**
**Objetivo**: Endurecer la parte caliente sumergiéndola en líquido

- **Dónde**: Quench Tank (Tanque de templado)
- **Input**: Hot Part + Líquido (agua, aceite)
- **Acción**: Click derecho con la parte caliente (usando tenazas)
- **Resultado**: Cold Part (parte fría lista - ej. "Sword Blade")
- **Efectos**: Vapor, sonido de siseo, enfriamiento instantáneo
- **Estado visual**: De rojo brillante a color normal del metal

### 🔧 **Fase 4: ASSEMBLY (Ensamblaje)**
**Objetivo**: Unir las partes frías para crear el arma completa

- **Dónde**: Armorer's Bench (Mesa de armero)
- **Input**: Múltiples Cold Parts (hoja, mango, guarda, pomo)
- **Acción**: Colocar partes → Golpear uniones con martillo
- **Resultado**: Arma modular completa (ej. "Iron Sword")
- **Mecánica**: Sistema de "snap" - las piezas se imanan a su posición correcta
- **Estado visual**: Partes translúcidas → sólidas al fijarlas

---

## 🏗️ 3. Las Estaciones de Trabajo (Workstations)

### 📐 **Estación 0: DRAFTING STATION** (Mesa de Delineante)
*Para copiar planos técnicos del Manual del Maestro Herrero*

#### Estructura:
```
┌─────────────────────┐
│  Drafting Station   │ ← Escritorio inclinado con libro
└─────────────────────┘
```

**Tipo de Bloque**: Individual (no multibloque)

#### Construcción:
- Crafteo: 4 Planks + 2 Sticks + 1 Book
- Colocar en el mundo como mesa de trabajo

#### Modelo Visual:

**Estado Inactivo**:
```
📕 Libro grande de cuero CERRADO sobre escritorio inclinado
🖋️ Tintero al lado
📏 Regla y compás decorativos (opcional)
```

**Estado Activo** (jugador usando):
```
📖 Libro se ABRE animadamente (tapa rota -90°)
📄 Páginas pasan aleatoriamente (animación tipo enchanting table pero horizontal)
✨ Partículas sutiles de polvo/tinta (opcional)
```

#### Funcionamiento:

##### **GUI Estilo Libro Abierto (Book-style)**:
```
┌─────────────────────────────────────────────────────────────┐
│  [Slot Izq: Template Base] [Slot Der: Ink Sac/Black Dye]  │
├─────────────────────────────────────────────────────────────┤
│                    LIBRO ABIERTO (2 páginas)                │
│  ┌──────────────────────┬──────────────────────┐            │
│  │  PÁGINA IZQUIERDA    │  PÁGINA DERECHA      │            │
│  │                      │                      │            │
│  │  ╔═══════════╗       │   Arma seleccionada: │            │
│  │  ║   DAGGER  ║       │   🗡️ DAGGER         │            │
│  │  ╚═══════════╝       │                      │            │
│  │                      │   Componentes:       │            │
│  │    [Ilustración]     │   ┌────────────────┐ │            │
│  │        ⚔️            │   │ ☑ Knife Blade  │ │            │
│  │     /  │  \          │   │ ☐ Small Guard  │ ← Click     │
│  │    ╱   │   ╲         │   │ ☐ Short Handle │ │            │
│  │   1    2    3        │   │ ☐ Pommel       │ │            │
│  │  Blade Guard Handle  │   └────────────────┘ │            │
│  │                      │                      │            │
│  │  [< Prev] [Next >]   │   Requisitos:        │            │
│  │                      │   • 1 Lingote        │            │
│  └──────────────────────┴──────────────────────┘            │
├─────────────────────────────────────────────────────────────┤
│  [Slot Output: Template de parte seleccionada]             │
└─────────────────────────────────────────────────────────────┘
```

**Página izquierda**: Ilustración del arma completa con números en cada parte  
**Página derecha**: Lista de componentes clickeables con checkboxes

##### **Paso 1: Preparar Materiales**
- Obtener **Template Base** (crafteo: 1 Paper + 1 Blue Dye = papel azul en blanco)
- Conseguir **Ink Sac** (de squid) o **Black Dye**

##### **Paso 2: Abrir el Manual**
1. Click derecho en Drafting Station → Abre GUI tipo libro
2. **Efecto visual**: El libro físico en la mesa se abre animadamente
3. **Vista inicial**: Primera arma del catálogo (Dagger)

##### **Paso 3: Navegar el Catálogo**
- **Botones [< Prev] [Next >]**: Cambiar entre páginas de armas
- **Cada página muestra**:
  - Ilustración del arma completa estilo blueprint/schematic
  - Números en cada componente (1=Blade, 2=Guard, 3=Handle, etc.)
  - Lista de partes con checkboxes en página derecha
  - Requisitos de materiales para cada parte
  
**Armas disponibles** (basadas en los sprites existentes):
```
=== ARMAS BÁSICAS (Desbloqueadas por defecto) ===
Página 1: Dagger (Daga) - 16x16
Página 2: Sword (Espada) - 16x16
Página 3: Axe (Hacha de batalla) - 16x16
Página 4: Pickaxe (Pico) - 16x16
Página 5: Shovel (Pala) - 16x16

=== ARMAS AVANZADAS (Requieren Lost Pages) ===
Página 6: 🔒 Katana - 32x32
Página 7: 🔒 Longsword/Greatsword (Mandoble) - Requiere página perdida
Página 8: 🔒 Spear (Lanza) - 32x32
Página 9: 🔒 Halberd (Alabarda) - Requiere página perdida
Página 10: 🔒 Rapier (Estoque) - Requiere página perdida
```

##### **Paso 4: Seleccionar Parte**
1. Colocar Template Base y Ink Sac en los slots superiores
2. En la página del arma deseada, **click en el checkbox** de la parte específica
   - Ejemplo: En página "Sword", click en "☐ Sword Blade"
   - El checkbox se marca: "☑ Sword Blade"
3. La parte seleccionada aparece en el slot de output
4. **Animación**: Las páginas del libro pasan mostrando detalles de esa parte específica

##### **Paso 5: Copiar Plano**
- Click en el output slot para recoger la Template
- **Consume**: 1 Template Base + 1 Ink Sac
- **Sonido**: Scratching pen (pluma escribiendo sobre papel)
- **Efecto visual**: 
  - Partículas de tinta flotando del libro al output
  - Páginas pasan rápidamente
- **Resultado**: Template de la parte específica lista para el yunque

#### Ventajas del Sistema:

✅ **Descubrimiento Contextual**: Ves armas completas y entiendes qué partes necesitas  
✅ **Visual Intuitivo**: Ilustraciones estilo blueprint muestran cómo se ensambla cada arma  
✅ **Inmersión Total**: El libro físico se abre en la mesa, páginas pasan al navegar  
✅ **Progresión Natural**: Armas básicas desbloqueadas, avanzadas requieren páginas raras  
✅ **Simplicidad**: Solo papel azul + tinta, seleccionas parte específica del arma  
✅ **No Clutter**: No guardas 50 templates, solo creas las que vas a usar inmediatamente

#### Notas Técnicas:
**BlockEntity**:
```java
DraftingStationBlockEntity {
    int numPlayersUsing; // Contador de jugadores con GUI abierta
    float bookOpenProgress; // 0.0-1.0 para animación de apertura
    int pageFlipTick; // Timer para animación de páginas
    Set<ResourceLocation> unlockedWeapons; // Armas desbloqueadas (por páginas)
    
    // Métodos
    boolean isWeaponUnlocked(WeaponType weapon);
    void unlockWeapon(ResourceLocation weaponId);
}
```
```

**Modelo (Blockbench)**:
- Escritorio base (estático)
- Libro con 2 huesos (bones):
  - `book_cover`: Tapa que rota de 0° a -90°
  - `pages`: Páginas que se mueven aleatoriamente
- Tintero y pluma (decoración estática)

**Animación**:
```java
// En BlockEntityRenderer
float progress = Mth.lerp(partialTick, 
    entity.bookOpenProgressOld, 
    entity.bookOpenProgress);
bookCoverBone.xRot = progress * -1.571f; // -90° en radianes

// Flip páginas mientras está abierto
**GUI (Custom Screen)**:
- Extender de `AbstractContainerScreen`
- **Background**: Textura de libro abierto (2 páginas, 256x180px estilo Minecraft)
- **Página Izquierda**: 
  - Renderizar ilustración del arma (ItemStack render o textura custom)
  - Números flotantes en cada componente
  - Botones [< Prev] [Next >] abajo
- **Página Derecha**:
  - Lista de componentes con checkboxes clickeables
  - Tooltip al hover mostrando stats requeridas
  - Requisitos (lingotes, tamaño de yunque)
- **Lógica**:
  - `currentWeaponPage` (int) para saber qué arma mostrar
  - `List<WeaponType> availableWeapons` filtra según desbloqueos
  - Click en checkbox → actualiza output slot si hay materiales

**GUI (Custom Screen)**:
- Extender de `AbstractContainerScreen`
- Renderizar lista scrolleable de diseños con iconos
- Similar a Stonecutter pero con 2 input slots

---

### 🔥 **Estación 1: EMBER HEARTH** (La Fragua)
*Para calentar metales hasta hacerlos maleables*

#### Estructura:
```
┌─────────────┐
│ Hearth Bed  │ ← Bloque Superior (aquí se colocan los lingotes)
├─────────────┤
│   Firebox   │ ← Bloque Inferior (combustible o fuente de calor)
└─────────────┘
```

**Tipo de Multibloque**: Vertical (1x2)

#### Construcción:
1. Colocar **Firebox** (bloque inferior) en el suelo
2. Colocar **Hearth Bed** (bloque superior) justo encima
3. ✅ Se forma la estructura automáticamente

#### Funcionamiento:
1. **Activar**: 
   - Click derecho en Firebox con combustible (carbón, madera, lava bucket)
   - O colocar debajo una fuente de calor (fuego, blaze burner de Create)

2. **Usar**:
   - Click derecho en Hearth Bed con lingotes (máximo 4 a la vez)
   - Los lingotes aparecen flotando encima del bloque
   - Cambio de color progresivo según temperatura NBT

3. **Retirar**:
   - ⚠️ **CON TENAZAS**: Click derecho → lingote caliente sin daño
   - ❌ **SIN TENAZAS**: Intentar agarrar → recibes daño de fuego + lingote se cae

#### Visualización:
```
Temperatura → Color del Lingote
  0-25%    →  Gris (frío)
 25-50%    →  Naranja oscuro
 50-75%    →  Rojo brillante
 75-100%   →  Blanco incandescente (óptimo para forjar)
```

#### Notas Técnicas:
- BlockEntity almacena: fuel, burn_time, items_on_top (List<ItemStack>)
- BER renderiza los lingotes flotando con color dinámico
- Tick cada segundo para calentar items y consumir fuel

---

### 🔨 **Estación 2: GRAND ANVIL** (El Gran Yunque)
*Para forjar el metal caliente y darle forma*

#### Estructura:
```
Configuración 1 bloque:          Configuración 2 bloques:
┌─────────────┐                  ┌─────────────┬─────────────┐
│    Anvil    │                  │  Anvil LEFT │ Anvil RIGHT │
└─────────────┘                  └─────────────┴─────────────┘
Partes pequeñas/medianas         Partes grandes (mandoble, alabarda)
```

**Tipo de Multibloque**: Horizontal (1-2 bloques máximo)

#### Construcción:
1. **Yunque Simple**: Colocar 1 bloque de Grand Anvil
2. **Yunque Doble**: Colocar 2 bloques uno al lado del otro (EAST/WEST)
   - ✅ Se detectan automáticamente y forman el multibloque
   - BlockState cambia: `part=left` y `part=right`
---

### 💧 **Estación 3: QUENCH TANK** (Tanque de Templado)
*Para endurecer las partes calientes sumergiéndolas en líquido*

#### Estructura:
```
Configuración 1 bloque:          Configuración 2 bloques:
┌─────────────┐                  ┌─────────────┬─────────────┐
│    Tank     │                  │  Tank LEFT  │ Tank RIGHT  │
│   (cubo)    │                  │   (bañera larga)          │
└─────────────┘                  └─────────────┴─────────────┘
Partes pequeñas                  Partes largas (hojas, astas)
```

**Tipo de Multibloque**: Horizontal (1-2 bloques máximo)

#### Construcción:
1. **Tanque Simple**: 1 bloque (forma cúbica)
2. **Tanque Doble**: 2 bloques lado a lado (forma de bañera alargada)

#### Preparación:
**Llenar con líquido** antes de usar:
- Click derecho con **Water Bucket** → llena con agua
- Click derecho con **Oil Bottle** → llena con aceite (opcional, mejor templado)
- O usar **Spout de Create** para llenar automáticamente

**Capacidad**: 
- 1 bloque: ~10 usos
- 2 bloques: ~20 usos

#### Funcionamiento:

##### **Paso 1: Tomar la Hot Part**
- Con **Tenazas** en mano, click derecho en la Hot Part del yunque
- La parte caliente se añade al inventario (aún caliente, no puedes sostenerla sin tenazas)

##### **Paso 2: Templar**
- Click derecho en el tanque lleno **mientras sostienes la Hot Part con tenazas**
- **Efecto inmediato**:
  - 💨 Explosión de partículas de vapor
  - 🔊 Sonido fuerte de siseo ("TSSSSS")
  - 💧 Consume 1 uso de líquido del tanque
  - 🥶 La parte se enfría instantáneamente

##### **Paso 3: Resultado**
- La **Hot Part** se convierte en **Cold Part** (parte fría)
- Ejemplo: "Hot Sword Blade" → "Sword Blade"
- Ahora puedes sostenerla con la mano sin tenazas
- Lista para ensamblar en la Armorer's Bench

#### Tipos de Líquido:

| Líquido | Efecto | Disponibilidad |
|---------|--------|----------------|
| **Agua** | Templado estándar | Vanilla |
| **Aceite** | +5% durabilidad | Crafteado |
| **Lava** | +10% daño, -20% durabilidad | Vanilla |
| **Agua de Alma** ⭐ | Propiedades mágicas | Forbidden & Arcanus |

#### Visualización:
- **Tanque lleno**: Líquido visible dentro (modelo 3D de fluido)
- **Nivel de líquido**: Baja gradualmente con cada uso
- **Efecto de vapor**: Nube densa de partículas al templar

#### Notas Técnicas:
- BlockEntity almacena: fluid_type, fluid_amount (int)
- Detecta si la parte es "hot" mediante NBT temperature > 75
- Al templar: temperatura NBT → 0, convierte item hot → cold
  - Medium Guard    → 1 lingote caliente
  
  Partes Grandes (2 bloques):
  - Longsword Blade → 3 lingotes calientes
  - Spearhead       → 2 lingotes calientes
  - Large Plate     → 3 lingotes calientes
  ```

##### **Paso 2: Colocar Template**
- Click derecho con la **Template** (plantilla) adecuada
- La plantilla se "impregnará" en el yunque
- Aparece una silueta/guía visual de la forma objetivo

##### **Paso 3: Forjar**
- Click derecho repetidamente con el **Hammer** (martillo)
- **Cada golpe**:
---

### 🔧 **Estación 4: ARMORER'S BENCH** (Mesa de Armero)
*Para ensamblar las partes frías en armas completas*

#### Estructura:
```
1 Bloque:                          2 Bloques:
┌──────────┐                       ┌──────────┬──────────┐
│  Bench   │                       │ Bench L  │ Bench R  │
└──────────┘                       └──────────┴──────────┘
Armas cortas/medianas              Armas largas (32x32 sprites)
(Daga, Espada, Hacha)              (Katana, Lanza, Mandoble)
```

**Tipo de Multibloque**: Horizontal (1-2 bloques máximo)

#### Construcción:
- **Mesa Simple**: 1 bloque para armas con sprites 16x16
- **Mesa Doble**: 2 bloques lado a lado (EAST/WEST) para armas con sprites 32x32
- **Detección automática**: Al colocar un segundo bloque adyacente, se forma el multibloque
- **Límite**: Máximo 2 bloques en línea (suficiente para sprites 32x32)
---

## 🛠️ 4. Items Esenciales del Herrero

### 🔧 **Tongs (Tenazas)**
**Función**: Manipular items calientes sin quemarse

- **Crafteo**: 2 Iron Ingots + 1 Stick
- **Durabilidad**: 250 usos
- **Mecánica**:
  - Shift + Click derecho en item caliente → lo recoge sin daño
  - Sin tenazas → daño de fuego + item se cae al suelo
- **Visual**: Se ven en la mano del jugador sosteniendo el item caliente

### 🔨 **Hammer (Martillo)**
**Función**: Golpear yunque y fijar uniones en mesa

- **Crafteo**: 3 Iron Ingots + 2 Sticks
- **Durabilidad**: 500 usos
- **Mecánica**:
  - Click derecho en yunque → avanza progreso de forjado
  - Click derecho en mesa → fija unión entre partes
  - Consume 1 durabilidad por golpe
- **Efectos**: Sonido metálico + partículas de chispas

### 📋 **Templates (Plantillas)**
**Función**: Definir qué parte se va a forjar en el yunque

**Obtención**: Se crean en la **Drafting Station** copiando diseños del manual

**Templates disponibles** (según partes de las armas):

**Hojas/Cabezas (Blades/Heads):**
1. Knife Blade Template (16x16)
2. Sword Blade Template (16x16)
3. Katana Blade Template (32x32) 🔒
4. Spearhead Template (32x32) 🔒
5. Axe Head Template (16x16)
6. Pickaxe Head Template (16x16)
7. Shovel Head Template (16x16)

**Mangos (Handles):**
8. Short Handle Template (16x16)
9. Medium Handle Template (16x16)
10. Long Handle Template (32x32) 🔒

**Guardas (Guards):**
11. Small Guard Template (16x16)
12. Medium Guard Template (16x16)
13. Large Guard Template (16x16)

**Accesorios:**
14. Binding Template (16x16)
15. Pommel Template (16x16)

#### **Proceso de Creación**:
1. **Craftear Template Base**: 1 Paper + 1 Blue Dye = Papel azul en blanco
2. **Ir a Drafting Station**: Abrir GUI con click derecho
3. **Seleccionar diseño**: Del catálogo visual completo
4. **Copiar con tinta**: 1 Template Base + 1 Ink Sac = 1 Template específica

#### **Características**:
- **Usos**: 1 uso (se consume al forjar completamente)
- **Visual**: Papel azul con silueta negra de la pieza
- **Tooltip**: Muestra requisitos (ej. "Requiere 2 lingotes calientes")
- **Mecánica**: Se coloca sobre el yunque antes de comenzar el forjado

---

## 💻 5. Requisitos Técnicos (Para Desarrollo)

### **A. Sistema de Temperatura (Data Component)**
```java
TemperatureComponent {
    int heatLevel (0-100)
    long lastUpdateTick
    
    boolean isMalleable() // >= 75 para forjar
    void coolDown(Level level) // Pierde calor con el tiempo
    int getVisualColor() // RGB según temperatura
}
```

**Aplicar a**:
- Todos los lingotes vanilla (iron, gold, copper, etc.)
- Lingotes custom (netherite, obsidian)
- Hot Parts (partes recién forjadas)

**Mecánicas**:
- Se enfría gradualmente (1% cada 2 segundos fuera de fragua)
- Si cae debajo de 50% en el yunque → reiniciar proceso
- Items fríos (<10%) vuelven a estado normal

### **B. Multibloque Horizontal**
```java
BlockState properties:
- facing: NORTH/SOUTH/EAST/WEST
- part: SINGLE / LEFT / RIGHT  // Máximo 2 bloques
- formed: true/false

Detección:
- onPlace() → checkNeighbors(EAST/WEST)
- Si hay bloque compatible → formar multibloque
- Actualizar modelos según posición
- Límite: 2 bloques máximo (suficiente para sprites 32x32)
```

### **C. BlockEntity Renderer (BER)**
**Crítico para mostrar items en el mundo**

```java
Ember Hearth BER:
- Renderizar hasta 4 lingotes flotantes
- Color dinámico según temperatura
- Efecto de brillo/emisión si están calientes

Grand Anvil BER:
- Renderizar lingotes + template
- Mostrar progreso de deformación
- Partículas de chispas al golpear

Quench Tank BER:
- Renderizar nivel de líquido dentro
- Efecto de ondulaciones al templar

Armorer's Bench BER:
- Renderizar múltiples partes (hasta 4)
- Estado translúcido vs sólido
- Modelo 3D del arma final al completar
```

### **D. Sistema de Validación**
```java
RecipeValidator {
    boolean hasCorrectIngots(int required, List<ItemStack> ingots)
    boolean areIngotsHot(List<ItemStack> ingots)
    boolean isTemplateValid(ItemStack template, PartType output)
    
    WeaponRecipe getRecipe(List<PartType> parts)
    boolean canAssemble(List<ItemStack> parts)
}
```

---

## 🔗 6. Compatibilidad con Otros Mods

### **Create Mod** 🔧
**Automatización del proceso de herrería**

- **Mechanical Press**: Simula golpes de martillo en yunque
- **Blaze Burner**: Fuente de calor para Firebox (más eficiente)
- **Spout**: Llena automáticamente Quench Tanks
- **Deployer**: Coloca lingotes en Hearth Bed
- **Mechanical Arm**: Mueve items entre estaciones

### **Forbidden & Arcanus** 🔮
**Materiales mágicos y líquidos especiales**

- **Soul Water**: Líquido de templado que otorga propiedades mágicas
- **Dark Matter**: Material de forja end-game
- **Edelwood**: Madera mágica para mangos con encantamientos mejorados

### **Early Game** (Fase 1-2)
```
🌳 Madera/Piedra
├─ Crafteo vanilla normal (sin mod)
├─ Tutorial: Construir Drafting Station
├─ Crear Template Base (papel azul)
├─ Copiar primer template (Knife Blade)
├─ Construir Ember Hearth básico
└─ Primeras herramientas: Tongs, Hammer
```

## 📈 7. Progresión del Jugador

### **Early Game** (Fase 1-2)
```
🌳 Madera/Piedra
├─ Crafteo vanilla normal (sin mod)
├─ Introducción: Construir Ember Hearth básico
### **Mid Game** (Fase 3-5)
```
⛏️ Hierro/Cobre
├─ Expandir catálogo de templates (explorar Drafting Station)
├─ Construir estaciones completas (Anvil, Tank, Bench)
├─ Forjar primeras partes de hierro
├─ Experimentar con combinaciones de materiales
└─ Crear armas modulares básicas
```Forjar primeras partes de hierro
├─ Experimentar con combinaciones de materiales
└─ Crear armas modulares básicas
```

### **Late Game** (Fase 6-8)
```
💎 Diamante/Netherite
├─ Anviles dobles para piezas grandes
├─ Templates avanzados
├─ Armas completas de alta calidad
└─ Optimización de stats mediante combinaciones
```

### **End Game** (Fase 9+)
```
🌟 Obsidiana/Materiales Mágicos
├─ Talleres completos automatizados (con Create)
├─ Armas legendarias con todos los modificadores
├─ Producción en masa para comercio/roleplay
└─ Compatibilidad con mods mágicos (F&A)
```

---
**P: ¿Tengo que memorizar crafteos de templates?**  
R: No, la Drafting Station muestra cada arma ilustrada como blueprint. Ves todos los componentes numerados y seleccionas el que necesitas.

**P: ¿Cómo desbloqueo armas avanzadas como Katana o Halberd?**  
R: Busca "Lost Pages" (Páginas Perdidas) en cofres de dungeons, tradea con Weaponsmiths Master, o derrota bosses. Usa la página en la Drafting Station para desbloquear permanentemente esa arma.

**P: ¿Las Lost Pages se consumen al usarlas?**  
R: Sí, pero el desbloqueo es permanente. Una vez desbloqueada, esa arma siempre estará disponible en esa Drafting Station (o para ese jugador si usas sistema global).

**P: ¿Por qué no GUIs?**  
R: Mayor inmersión, todo visual en 3D, más satisfactorio y cinematográfico.

**P: ¿Y si el metal se enfría en medio del forjado?**  
R: Debes recalentar los lingotes en la fragua y reintentar. Añade tensión al proceso.
**P: ¿Cómo sé cuántos lingotes necesito?**  
R: Las templates tienen tooltip indicando cantidad requerida. También puedes verlo en la Drafting Station antes de copiar el plano.

**P: ¿Tengo que memorizar crafteos de templates?**  
R: No, la Drafting Station muestra todos los diseños disponibles visualmente. Solo necesitas papel azul + tinta.
R: Sí, ej. mango de madera + hoja de hierro. Las stats se combinan.

**P: ¿Cómo sé cuántos lingotes necesito?**  
R: Las templates tienen tooltip indicando cantidad requerida.

**P: ¿Las estaciones se rompen con el uso?**  
R: No, son permanentes. Solo las herramientas (hammer, tongs) tienen durabilidad.

**P: ¿Puedo acelerar el proceso?**  
R: Sí, con Create (presses, deployers) o mejores combustibles en la fragua.

---

### Concepto Narrativo:

El **"Manual del Maestro Herrero"** es el libro que aparece en la Drafting Station. Según el lore del mod:

> *"Este antiguo tomo fue escrito por los primeros maestros herreros, quienes documentaron meticulosamente cada diseño de arma conocido. Cada página ilustra un arma completa con precisión técnica, mostrando cada componente numerado. Al consultar sus páginas desgastadas y seleccionar una parte específica, puedes copiar el plano técnico a papel usando tinta común."*

### En Juego:

#### **Mecánica Core**:
- **Visualización tipo Catálogo**: Cada página = 1 arma completa ilustrada
- **Ilustraciones Blueprint**: Dibujos técnicos estilo ingeniería medieval
- **Navegación**: Botones para pasar páginas entre diferentes armas
- **Selección Interactiva**: Click en componentes específicos del arma para copiarlos

#### **Sistema de Ilustraciones**:
```
Ejemplo - Página de "SWORD":
┌─────────────────────────┐
│      ⚔️ ESPADA         │
│                         │
│         1               │
---

## 📊 11. Resumen Visual del Sistema Completo

### Flujo de Juego Completo:
```
1. 🏗️ Construir Drafting Station
         ↓
2. 📖 Abrir Manual del Maestro Herrero
         ↓
3. 📄 Navegar páginas de armas (ilustraciones blueprint)
         ↓
4. 🔓 (Opcional) Desbloquear armas avanzadas con Lost Pages
         ↓
5. ☑️ Seleccionar componente específico del arma deseada
         ↓
6. 🖋️ Copiar plano con Template Base + Tinta
         ↓
7. 🔥 Calentar lingotes en Ember Hearth
         ↓
8. 🔨 Forjar parte en Grand Anvil usando Template
         ↓
9. 💧 Templar parte caliente en Quench Tank
         ↓
10. 🔧 Ensamblar partes frías en Armorer's Bench
         ↓
11. ⚔️ Obtener arma modular completa!
```

### Ejemplo Práctico - Crear una Katana:

**Paso 1**: Encontrar "Lost Page: Katana" en cofre de End City  
**Paso 2**: Click derecho en Drafting Station con página → Desbloquea Katana  
**Paso 3**: Abrir GUI, navegar hasta página "KATANA"  
**Paso 4**: Ver ilustración blueprint de Katana (3 partes: Blade + Binding + Handle)  
**Paso 5**: Click en checkbox "☐ Katana Blade" → Copiar template  
**Paso 6**: Repetir para Binding y Short Handle  
**Paso 7**: Forjar las 3 partes con sus respectivas templates  
**Paso 8**: Ensamblar en Armorer's Bench (2 bloques - necesario para Katana Blade 32x32)  
**Paso 9**: Obtener Katana completa con stats combinadas!

**Nota**: La Katana requiere mesa de 2 bloques porque su Katana Blade usa sprite 32x32 que no cabe en 1 bloque.

---

**Última actualización**: 3 Diciembre 2025 v5.1  
**Estado**: Concepto final con GUI tipo libro ilustrado + sistema de progresión  
**Cambios v5.1**: 
- GUI rediseñada como libro abierto con ilustraciones de armas completas
- Sistema de navegación por páginas (una arma por página)
- Selección de componentes específicos con checkboxes
- Sistema de progresión con Lost Pages para armas avanzadas
- Desbloqueos permanentes vía loot/trading/bosses

**Próximo paso**: Implementar Drafting Station GUI + Lost Pages + Sistema de Temperatura
│         │               │
│      ───┼───            │
│         3               │
│         4               │
│                         │
│ 1 = Blade (Hoja)       │
│ 2 = Guard (Guarda)     │
│ 3 = Handle (Mango)     │
│ 4 = Pommel (Pomo)      │
└─────────────────────────┘
```

#### **Sistema de Progresión - Páginas Perdidas** 🔒:

**Armas Básicas** (Desbloqueadas por defecto - sprites 16x16):
- ✅ Dagger (Daga) - 1 bloque
- ✅ Sword (Espada) - 1 bloque
- ✅ Axe (Hacha de batalla) - 1 bloque
- ✅ Pickaxe (Pico) - 1 bloque
- ✅ Shovel (Pala) - 1 bloque

**Armas Avanzadas** (Requieren "Lost Pages" - sprites 32x32):
- 🔒 Katana → Requiere **"Página Perdida: Katana"** - 2 bloques
- 🔒 Spear (Lanza) → Requiere **"Página Perdida: Spear"** - 2 bloques
- 🔒 Greatsword/Longsword (Mandoble) → **"Página Perdida: Greatsword"** - 2 bloques (futuro)
- 🔒 Halberd (Alabarda) → **"Página Perdida: Halberd"** - 2 bloques (futuro)
- 🔒 Rapier (Estoque) → **"Página Perdida: Rapier"** - 2 bloques (futuro)

#### **Lost Pages (Páginas Perdidas)** 📄:

**Item: Lost Page**
- **Apariencia**: Papel viejo, amarillento, con bordes quemados
- **Tipos**: Cada arma avanzada tiene su página específica
- **Uso**: Click derecho en Drafting Station con página en mano
  - Consume la página
  - Desbloquea permanentemente esa arma en el libro
  - Efecto: Páginas del libro brillan, sonido mágico
  - Mensaje: *"Has restaurado el conocimiento perdido de [Arma]"*

**Obtención de Lost Pages**:
1. **Loot de Cofres**:
   - Dungeon chests (5% chance)
   - Stronghold libraries (10% chance)
   - Nether fortress (7% chance - armas de fuego)
   - End cities (15% chance - armas exóticas)

2. **Trades con Aldeanos**:
   - **Weaponsmith Master**: 20 Emeralds → 1 Lost Page (random)
   - **Cartographer Master**: 15 Emeralds + 5 Paper → 1 Lost Page específica

3. **Boss Drops** (opcional):
   - Ender Dragon: Lost Page: Rapier (100%)
   - Wither: Lost Page: Warhammer (100%)

4. **Crafting Avanzado** (costoso):
   - 8 Paper + 1 Nether Star → Lost Page (random)

#### **Visual en GUI cuando está bloqueado**:
```
Página bloqueada:
┌─────────────────────────┐
│    🔒 KATANA 🔒        │
│                         │
│      [Silueta borrosa]  │
│         ??????          │
│                         │
│  Requiere:              │
│  📄 Lost Page: Katana  │
│                         │
│  "Busca en cofres o     │
│   tradea con aldeanos"  │
└─────────────────────────┘
```

#### **Persistencia de Desbloqueos**:
- **Nivel de Bloque**: Cada Drafting Station guarda sus desbloqueos (NBT)
- **Nivel de Jugador**: Alternativa con capability/advancement para compartir entre estaciones
- **Servers Roleplay**: Admin puede usar comando `/moltensmith unlock <player> <weapon>` para eventos

### Ventajas del Sistema:

✅ **Rejugabilidad**: Incentiva exploración de estructuras para encontrar páginas  
✅ **Progresión Natural**: Armas básicas accesibles, exóticas requieren esfuerzo  
✅ **Trading Economy**: Las Lost Pages son valiosas para comercio entre jugadores  
✅ **Recompensa de Boss**: Da razón extra para pelear Wither/Dragon  
✅ **Flexibilidad**: Admin puede ajustar qué armas están bloqueadas via configes el libro que aparece en la Drafting Station. Según el lore del mod:

> *"Este antiguo tomo fue escrito por los primeros maestros herreros, quienes documentaron meticulosamente cada diseño de arma conocido. Al consultar sus páginas desgastadas, puedes copiar los planos técnicos a papel usando tinta común."*

### En Juego:

- **No es un item**: El libro solo existe visualmente en la Drafting Station
- **Funciona como "base de datos"**: Contiene todos los diseños desbloqueables
- **(Futuro) Sistema de Progresión**: Podrías añadir diseños avanzados que se desbloquean con achievements
- **Easter Eggs**: Las páginas podrían mostrar texto en Enchanting Table Language cuando se animan

### Alternativa para Roleplay Servers:

Si quieres hacer el sistema más "descubrimiento-based":
1. Ciertas templates podrían requerir encontrar **"Páginas Perdidas"** (items raros en cofres)
2. La Drafting Station sin la página correcta mostraría el diseño pero bloqueado
3. Añade rejugabilidad y exploración

---

**Última actualización**: 3 Diciembre 2025 v5.0  
**Estado**: Concepto final con Drafting Station integrada  
**Próximo paso**: Implementar Drafting Station + GUI + Sistema de Temperatura
**Última actualización**: 2 Diciembre 2025 v4.0  
**Estado**: Concepto final aprobado, listo para implementación  
**Próximo paso**: Implementar Items de Herrero + Sistema de Temperatura
El sistema verifica automáticamente:
- ✅ Todas las partes requeridas presentes
- ✅ Partes compatibles entre sí (mismo material o permitido)
- ✅ Longitud de mesa correcta para el arma
- ❌ Si falta algo o está mal → mensaje en chat

##### **Paso 3: Fijar Uniones (Hammer)**
- Click derecho con **Hammer** en las **uniones** entre partes
- Cada unión necesita ~3 golpes de martillo
- **Visual**: Las uniones se vuelven sólidas, las partes pierden transparencia
- **Sonido**: "Clink clink clink" metálico

##### **Paso 4: Completar Arma**
- Cuando TODAS las uniones están fijadas:
  - Las partes se fusionan visualmente
  - El arma completa aparece como un solo modelo 3D
  - **Recoger**: Shift + Click Derecho para añadir al inventario
  - Ejemplo final: "Iron Longsword" (stats combinados de todas las partes)

#### Ejemplos de Ensamblaje:

**Daga (1 bloque):**
```
Knife Blade + Small Guard + Short Handle
= Rápida, bajo daño, compacta
```

**Espada (1 bloque):**
```
Sword Blade + Medium Guard + Medium Handle + Pommel
= Balanceada, versátil
```

**Katana (2 bloques):**
```
Katana Blade (32x32) + Binding + Short Handle
= Veloz, menos durable, requiere mesa doble
```

**Lanza (2 bloques):**
```
Spearhead (32x32) + Long Handle (32x32) + Pommel
= Máximo alcance, dos manos, requiere mesa doble
```

#### Mecánicas Especiales:
- **Validación de tamaño**: Si intentas ensamblar arma 32x32 en mesa de 1 bloque → mensaje de error "Requiere mesa más grande"
- **Visualización 3D**: Cada parte se renderiza individualmente hasta ser fijada
- **Escala automática**: Sprites 32x32 se renderizan más grandes que 16x16
- **Compatibilidad de materiales**: Puedes mezclar (mango de madera + hoja de hierro)
```

#### Mecánicas Especiales:
- **Expansión dinámica**: La mesa detecta el arma y sugiere añadir bloques si es muy larga
- **Visualización 3D**: Cada parte se renderiza individualmente hasta ser fijada
- **Compatibilidad de materiales**: Puedes mezclar (mango de madera + hoja de hierro)
#### Notas Técnicas:
- BlockEntity almacena: parts (Map<SlotType, ItemStack>), joints_fixed (Set<Junction>)
- BER complejo: renderiza múltiples items con estados (translúcido/sólido)
- **Escalado de renderizado**: 
  - Sprites 16x16 → escala 1.0x (normal)
  - Sprites 32x32 → escala 1.5x o span entre 2 bloques
- Validador de recetas: compara contra registry de armas válidas
- Detección de tamaño: Verifica si arma requiere 1 o 2 bloques según sprite sizesdo/sólido)
- Validador de recetas: compara contra registry de armas válidas
 75%  → Forma reconocible
100%  → Forma perfecta = Hot Part completa
```

#### Mecánicas Especiales:
- **Si el metal se enfría** (pierde temperatura): Los lingotes vuelven a temperatura ambiente y debes recalentarlos
- **Si retiras lingotes antes de terminar**: Pierdes el progreso
- **Yunque doble**: Permite forjar piezas que no cabrían en 1 bloque (visualización más grande)

#### Notas Técnicas:
- BlockEntity almacena: ingots (List<ItemStack>), template, progress (float 0.0-1.0)
- BER renderiza: lingotes flotantes + silueta de template + progreso visual
- Validación: Cantidad correcta de lingotes calientes + temperatura adecuada

Fase 3: El Tanque de Templado (The Quench Tank)
Para enfriar y endurecer la parte.

Estructura: Multibloque Horizontal (1 o 2 bloques de largo).

1 Bloque: Tanque cúbico para partes pequeñas.

2 Bloques: Bañera larga para partes que no caben en un cubo (Hojas largas, Astas).

Interacción:

Llenar el tanque con líquido (Agua, Aceite, etc.).

Click derecho con la Parte Caliente (usando Tenazas).

Efecto: Partículas de vapor, sonido de siseo.

Resultado: La parte se enfría instantáneamente y se convierte en Parte Fría (ej. Sword Blade). Ahora se puede tomar con la mano.

Fase 4: La Mesa de Armero (Armorer's Bench)
Para el ensamblaje final.

Estructura: Multibloque Horizontal Dinámico (1 a 3 bloques de largo).

Se expande según el largo del arma a crear.

3 Bloques: Necesario para armas de asta muy largas (Lanzas, Alabardas) para evitar que el modelo atraviese bloques.

Interacción (Snap & Hammer):

Colocación: Click derecho con las partes frías. El código detecta el slot lógico (Mango al centro, Punta al extremo) y las "imanta" en su lugar.

Validación: Las piezas se ven translúcidas o "sueltas".

Fijación: Golpear las uniones con el Martillo.

Resultado: Al completar todas las uniones, el arma se recoge con Shift + Click Derecho.

4. Requisitos Técnicos (Para Desarrollo)
Items & Datos
Temperature Capability: Todos los items de metal deben poder almacenar heat_level (int/float) y last_update_tick (long).

Hot State: Los items calientes deben ser inutilizables en crafteos normales hasta enfriarse.

Bloques & Renderizado
MultiblockShape: Sistema para detectar vecinos (EAST/WEST) y actualizar el BlockState (modelo left, middle, right).

BlockEntityRenderer (BER): Esencial para mostrar los items sobre el Yunque y la Mesa en tiempo real sin usar GUIs.

Compatibilidad Planeada
Create:

Mechanical Press puede simular clicks de Martillo.

Blaze Burner puede usarse como Bloque Inferior del Hearth.

Spout puede llenar los Tanques de Templado.

Forbidden & Arcanus:

Materiales mágicos pueden requerir líquidos de templado especiales (ej. Sangre, Agua de Alma).