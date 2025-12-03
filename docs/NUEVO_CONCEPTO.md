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

### Proceso de creación en 4 fases obligatorias:

```
🔥 HEATING → 🔨 FORGING → 💧 QUENCHING → 🔧 ASSEMBLY
(Calentar)   (Forjar)     (Templar)      (Ensamblar)
```

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
1 Bloque:                 2 Bloques:                3 Bloques:
┌──────────┐              ┌──────────┬──────────┐   ┌──────────┬──────────┬──────────┐
│  Bench   │              │ Bench L  │ Bench R  │   │ Bench L  │ Bench M  │ Bench R  │
└──────────┘              └──────────┴──────────┘   └──────────┴──────────┴──────────┘
Armas cortas              Armas medianas            Armas largas (lanza, alabarda)
```

**Tipo de Multibloque**: Horizontal Dinámico (1-3 bloques)

#### Construcción:
- **Colocación inteligente**: Al colocar bloques adyacentes (EAST/WEST), se expanden automáticamente
- **Límite**: Máximo 3 bloques en línea
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
**Función**: Definir qué parte se va a forjar

**7 tipos de templates:**
1. Knife Blade Template
2. Sword Blade Template
3. Katana Blade Template
4. Spearhead Template
5. Axe Head Template
6. Pickaxe Head Template
7. Shovel Head Template

- **Crafteo**: Paper + material correspondiente (ej. Iron Ingot para iron template)
- **Usos**: 1 uso (se consume al forjar) o durabilidad baja
- **Mecánica**: Se coloca sobre el yunque antes de forjar

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
- part: SINGLE / LEFT / MIDDLE / RIGHT
- formed: true/false

Detección:
- onPlace() → checkNeighbors(EAST/WEST)
- Si hay bloque compatible → formar multibloque
- Actualizar modelos según posición
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

### **Farmer's Delight** 🍲
- **Cooking Oil**: Alternativa al aceite para templado

### **Mekanism** ⚙️
- **Hydrogen**: Gas para templado avanzado (mayor durabilidad)

---

## 📈 7. Progresión del Jugador

### **Early Game** (Fase 1-2)
```
🌳 Madera/Piedra
├─ Crafteo vanilla normal (sin mod)
├─ Introducción: Construir Ember Hearth básico
└─ Primeras herramientas: Tongs, Hammer
```

### **Mid Game** (Fase 3-5)
```
⛏️ Hierro/Cobre
├─ Construir estaciones completas (Anvil, Tank, Bench)
├─ Forjar primeras partes de hierro
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

## ❓ 8. FAQ de Diseño

**P: ¿Por qué no GUIs?**  
R: Mayor inmersión, todo visual en 3D, más satisfactorio y cinematográfico.

**P: ¿Y si el metal se enfría en medio del forjado?**  
R: Debes recalentar los lingotes en la fragua y reintentar. Añade tensión al proceso.

**P: ¿Puedo mezclar materiales?**  
R: Sí, ej. mango de madera + hoja de hierro. Las stats se combinan.

**P: ¿Cómo sé cuántos lingotes necesito?**  
R: Las templates tienen tooltip indicando cantidad requerida.

**P: ¿Las estaciones se rompen con el uso?**  
R: No, son permanentes. Solo las herramientas (hammer, tongs) tienen durabilidad.

**P: ¿Puedo acelerar el proceso?**  
R: Sí, con Create (presses, deployers) o mejores combustibles en la fragua.

---

## 🎯 9. Diferencias Clave vs Tinkers' Construct

| Aspecto | Tinkers' Construct | MoltenSmith |
|---------|-------------------|-------------|
| **Fluidos** | Sí (metal fundido) | ❌ No |
| **Moldes** | Sí (12+ tipos) | ❌ No (usa templates) |
| **GUIs** | Múltiples GUIs complejas | ❌ Cero GUIs |
| **Visualización** | Solo en GUI | ✅ Todo en mundo 3D |
| **Proceso** | Fundir → Moldear | ✅ Calentar → Forjar → Templar → Ensamblar |
| **Realismo** | Arcade | ✅ Físico/Realista |
| **Multibloque** | Vertical 3D complejo | ✅ Horizontal simple 1-3 bloques |
| **Roleplay** | Limitado | ✅ Alto (talleres, comercio) |

---

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
Katana Blade + Binding + Short Handle
= Veloz, menos durable
```

**Lanza (3 bloques):**
```
Spearhead + Long Handle + Pommel
= Máximo alcance, dos manos
```

#### Mecánicas Especiales:
- **Expansión dinámica**: La mesa detecta el arma y sugiere añadir bloques si es muy larga
- **Visualización 3D**: Cada parte se renderiza individualmente hasta ser fijada
- **Compatibilidad de materiales**: Puedes mezclar (mango de madera + hoja de hierro)

#### Notas Técnicas:
- BlockEntity almacena: parts (Map<SlotType, ItemStack>), joints_fixed (Set<Junction>)
- BER complejo: renderiza múltiples items con estados (translúcido/sólido)
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