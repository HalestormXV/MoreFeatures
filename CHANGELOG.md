# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]
### Added:
- Added ore smelting and blasting recipe data generation
- Added generation config (No biome generation config sadly)
- Added github workflow/actions

### Changed:
- Changed hunger command suggestions to have a `ResourceLocation` pointing to the modid instead of "hunger"
- Changed ores to drop themselves when broken with silk touch and drop more gems when broken with fortune
- Changed armor recipe advancements to be named correctly when the repair material was a block
- Changed asbestos to not harm the player if broken with silk touch
- Changed sapphire ore to work with silk touch and fortune
- Changed corn crop's hitbox to match the size of the crop and changed corn crop's model to use `cross` instead of `crop`
- Changed the license to be in markdown and have a notice for the block loot table data generator
- Changed screen factory registration to be done using `DeferredWorkQueue`
- Changed `LanguageFilesDataGen` to give the correct name to curse enchantments and have support for other languages
- Changed config to be common, not server
- Changed sapphire and corrupted tools to have a harvest level of 3
- Changed build.gradle to have the curseforge plugin (for publishing from the command line)

### Fixed:
- Fixed config not changing how things work
- Fixed ores generating in the nether or end (might not have even happened, but just in case)

### Removed:
- Removed `registerBiomes()`

## [1.15.2-1.1.0] - 2020-6-27
### Added:
- Added some side checks (hopefully in the correct places)
- Added corrupted armor
- Added lemon and orange slabs, stairs, fences, buttons, pressure plates, and doors
- Added lemon and orange plain biomes
- Added data generation
- Added display box
- Added events (for people who want to link with this mod)

### Changed:
- Changed config to be for server, not client
- Changed saving grace to have 3 levels, each with a higher chance of survival
- Changed the amount of XP given for lapis armor
- Changed coal armor to harm players when they were burning quicker
- Changed beds to be flammable
- Changed lemon and orange tree settings slightly
- Changed corrupted tools to initialize with 0 attack speed and damage
- Changed some classes to be in different packages
- Changed the button item models to point to the correct block model

### Removed:
- Removed config options for feature generation due to configs being loaded after world generation
- Removed all tooltips/command feedback using `StringTextComponent` and changed them to use `TranslationTextComponent`

## [1.15.2-1.0.0] - 2020-6-18
### Added:
- Added items and blocks to forge tags
- Added a line to the top of the config file stating what it does

### Changed:
- Changed MCP mappings version
- Changed `CHANGELOG.md` to have the correct comparison links
- Changed wheat and corn to be flammable
- Changed commands to take in a player instead of a string and (again) made it (hopefully) server compatible
- Changed `isReady()` in asbestosis to return true if count is greater than 30
- Changed the fire retardant enchantment to check for when a player is damaged instead of every tick
- Changed the lemon texture to have some noise
- Changed registries to pass in `Item` or `Block` instead of their class
- Changed things like lapis armor, asbestosis and curse of harming to use `TickHandler`
- Changed curse of harming to harm the player every 20 ticks

### Removed:
- Removed removed command responses in the language file
- Removed `@SuppressWarnings("deprecation")` in `LemonSapling` and `OrangeSapling`

## [1.15.2-1.0.0-beta3] - 2020-6-13
### Added:
- Added death messages for when a player died while being attacked by another entity
- Added config options for tree and ore generation
- Added comments in main class

### Changed:
- Changed `/hunger`'s error messages to be more useful
- Changed "user not found" errors to (hopefully) only show if the command can't find the user
- Reformatted blockstates, tags, and smelting recipes
- Made coal armor usable as fuel
- Changed the saving grace enchantment to no longer have a null tag check (It isn't checking NBT anymore)
- Changed the soul harvester enchantment to no longer have `EquipmentSlotType.OFFHAND` (It doesn't check the offhand)
- Changed the main class's `@Mod` annotation to use `MOD_ID` in the main class

### Fixed:
- Fixed sapling tags
- Fixed asbestos not playing a breaking sound when broken

### Removed:
- Removed mod item tags
- Removed `isHoldingCtrl()` in KeyboardChecker
- Removed `init()` in MoreFeaturesItemGroup

## [1.15.2-1.0.0-beta2] - 2020-6-6
### Added:
- Added changelog
- Added leaves' loot tables
- Added blast-proof glass's loot table
- Added blocks to tags
- Added trees to world generation

### Changed
- Changed `/hunger`'s syntax
- Made blocks that were supposed to be flammable, flammable.
- Changed lemon and orange saplings to be compostable
- (Hopefully) changed the soul harvester enchantment to be server compatible
- Changed the sapphire sword and axe's attack damage
- Changed the orange tree to have orange wood instead of lemon wood (whoops)
- Changed the way how the saving grace and soul harvester enchantment works
- Changed asbestos to not apply the effect if you are in creative mode
- Changed the name of `MoreFeaturesOreGeneration` to `MoreFeaturesGeneration`

### Fixed
- Fixed [#7](https://github.com/xf8b/MoreFeatures/issues/7) (Effects applied by enchantments are still present after the armor has broken)
- Fixed a bug like [#7](https://github.com/xf8b/MoreFeatures/issues/7), but with armor which applied effects.

### Removed:
- Removed access transformer

## [1.15.2-1.0.0-beta1] - 2020-6-3
### Fixed:
- Fixed [#6](https://github.com/xf8b/MoreFeatures/issues/6) (Getting null tag causes crashes)

## [1.15.2-1.0.0-alpha6] - 2020-6-3
### Added:
- Added config
- Added curse enchantments
- Added new blocks
- Added new effect
- Added "armor" (if you call a mask armor, but it had to be registered as a `ArmorItem`)
- Added asbestos to generation
- Added corrupted tools
- Added crops
- Added commands

### Changed:
- Changed MCP mappings version
- Changed lapis armor to have local tick counters instead of using the `TickCounter` class
- Changed .gitignore to include ._ files
- Changed code to be formatted correctly

### Fixed:
- Fixed corrupted sword not changing attack damage and speed

## [1.15.2-1.0.0-alpha5] - 2020-5-25
### Added:
- Added new foods
- Added new trees
- Added enchantments

### Changed:
- Changed how the corrupted sword gets a random attack damage and speed
- Changed `README.md` to have stats about the mod on CurseForge
- Changed the issue templates to use "Versions" instead of "Desktop"
- Changed MCP mappings version
- Changed some items to be compostable

### Fixed:
- Fixed [#3](https://github.com/xf8b/MoreFeatures/issues/3) (Items in the MoreFeatures item group do not appear)
- Fixed [#4](https://github.com/xf8b/MoreFeatures/issues/4) (Fire Retardant enchantment doesn't work)

### Removed:
- Removed most of the item descriptions

## [1.15.2-1.0.0-alpha4] - 2020-5-17
### Added:
- Added coal armor
- Added lapis armor
- Added emerald armor

### Changed:
- Changed issue template to have correct spelling and be more easy to read
- Changed ore generation to be ran using `DeferredWorkQueue`
- Changed the locations of tools/items to be in packages (e.g. instead of all tools being in the tools package, it would be tools.sapphire)

### Fixed:
- Fixed [#2](https://github.com/xf8b/MoreFeatures/issues/2) (Obsidian armor causes fall damage death on crouch)

## [1.15.2-1.0.0-alpha3] - 2020-5-16
### Added:
- Added update.json
- Added obsidian armor

### Changed:
- Changed `README.md` to have the correct version number
- Changed the Forge version to 31.2.0
- Changed `build.gradle` to use values in `gradle.properties`

## [1.15.2-1.0.0-alpha2] - 2020-5-15
### Added:
- Added issue templates
- Added sapphire tool textures
- Added ore generation
- Added corrupted sword
- Added item descriptions
- Added item recipes
- Added loot tables
- Added smelting recipe
- Added sapphire ore

### Changed:
- Changed .gitignore to include .DS_Store
- Changed README.md to have the logo correctly display and have download links
- Changed the package name from com.github.xf8b.morefeatures to io.github.xf8b.morefeatures
- Changed MCP mappings version

### Fixed:
- Fixed [#1](https://github.com/xf8b/MoreFeatures/issues/1) (Flipped axe recipe doesn't work)

## [1.15.2-1.0.0-alpha1] - 2020-5-8
### Added: 
- Added sapphire armor
- Added sapphire tools
- Added sapphire
- Added sapphire block

[Unreleased]: https://github.com/xf8b/MoreFeatures/compare/v1.15.2-1.0.0...1.15.2-development
[1.15.2-1.1.0]: https://github.com/xf8b/MoreFeatures/compare/v1.15.2-1.0.0...v1.15.2-1.1.0
[1.15.2-1.0.0]: https://github.com/xf8b/MoreFeatures/compare/v1.15.2-1.0.0-beta3...v1.15.2-1.0.0
[1.15.2-1.0.0-beta3]: https://github.com/xf8b/MoreFeatures/compare/v1.15.2-1.0.0-beta2...v1.15.2-1.0.0-beta3
[1.15.2-1.0.0-beta2]: https://github.com/xf8b/MoreFeatures/compare/v1.15.2-1.0.0-beta1...v1.15.2-1.0.0-beta2
[1.15.2-1.0.0-beta1]: https://github.com/xf8b/MoreFeatures/compare/v1.15.2-1.0.0-alpha6...v1.15.2-1.0.0-beta1
[1.15.2-1.0.0-alpha6]: https://github.com/xf8b/MoreFeatures/compare/v1.15.2-1.0.0-alpha5...v1.15.2-1.0.0-alpha6
[1.15.2-1.0.0-alpha5]: https://github.com/xf8b/MoreFeatures/compare/v1.15.2-1.0.0-alpha4...v1.15.2-1.0.0-alpha5
[1.15.2-1.0.0-alpha4]: https://github.com/xf8b/MoreFeatures/compare/v1.15.2-1.0.0-alpha3...v1.15.2-1.0.0-alpha4
[1.15.2-1.0.0-alpha3]: https://github.com/xf8b/MoreFeatures/compare/v1.15.2-1.0.0-alpha2...v1.15.2-1.0.0-alpha3
[1.15.2-1.0.0-alpha2]: https://github.com/xf8b/MoreFeatures/compare/v1.15.2-1.0.0-alpha1...v1.15.2-1.0.0-alpha2
[1.15.2-1.0.0-alpha1]: https://github.com/xf8b/MoreFeatures/compare/192620cdc55ad2400d5ef5300c5c2b39a47276dd...v1.15.2-1.0.0-alpha1