# CustomUI Plugin

Minecraft плагин для Paper 1.21.7+ с использованием Dialog API для кастомизации интерфейса игроков.

## Возможности

- 🎨 **Меню для настройки Таба** - кастомизация header и footer
- 💬 **Меню для настройки Чата** - изменение формата и префиксов
- 📊 **Меню для настройки Скорборда** - настройка заголовка и линий
- 👤 **Меню для настройки Ника** - изменение префикса, суффикса и цвета
- 🏆 **Меню для настройки Титулов** - выбор рангов и титулов игроков
- 👁️ **Меню для настройки Дистанции Видимости** - слайдер для настройки view distance (8-24 чанка)
- ⚙️ **Пользовательские меню** - создание собственных меню через конфигурацию
- 🔧 **Гибкая конфигурация** - все настройки через YAML файлы
- 🎮 **Команды управления** - открытие меню для себя или других игроков
- 📝 **Полная поддержка PlaceholderAPI** - интеграция с популярными плагинами
- 🛡️ **Интеграция с LuckPerms** - автоматическая работа с правами и группами

## Установка

1. Скачайте плагин для Paper 1.21.7+
2. Поместите файл в папку `plugins/`
3. Перезапустите сервер
4. Настройте конфигурацию в папке `plugins/CustomUI/`

## Команды

| Команда | Описание | Права |
|---------|----------|-------|
| `/customui <menu>` | Открыть меню | `customui.use` |
| `/customui <menu> <player>` | Открыть меню для игрока | `customui.admin` |
| `/customui list` | Показать доступные меню | `customui.use` |
| `/customui reload` | Перезагрузить конфигурацию | `customui.admin` |
| `/customui help` | Показать справку | `customui.use` |

## Права

| Право | Описание | По умолчанию |
|-------|----------|--------------|
| `customui.use` | Использование основных команд | `true` |
| `customui.admin` | Административные команды | `op` |
| `customui.menu.tab` | Доступ к меню таба | `true` |
| `customui.menu.chat` | Доступ к меню чата | `true` |
| `customui.menu.scoreboard` | Доступ к меню скорборда | `true` |
| `customui.menu.displayname` | Доступ к меню ника | `true` |
| `customui.menu.title` | Доступ к меню титулов | `true` |
| `customui.menu.viewdistance` | Доступ к меню дистанции видимости | `true` |

## Конфигурация

### Основной файл конфигурации (`config.yml`)

```yaml
# Основные настройки
enabled: true
language: "ru"

# Настройки по умолчанию
defaults:
  allow-self-menu: true
  allow-admin-menu: true
  auto-apply: false

# Настройки меню
menus:
  enable-default-menus: true
  custom-menus-folder: "menus"
  max-custom-menus: 50
```

### Конфигурация меню

Каждое меню настраивается в отдельном файле в папке `menus/`:

#### Пример меню для таба (`menus/tab.yml`)

```yaml
title: "Настройка Таба"
description: "Выберите стиль для вашего таба"
type: "tab"

options:
  header: "&6&lВаш Таб"
  footer: "&7Добро пожаловать на сервер!"

actions:
  header: "tab_header %header%"
  footer: "tab_footer %footer%"
  apply: "tab_apply"
  reset: "tab_reset"
```

#### Пример меню для чата (`menus/chat.yml`)

```yaml
title: "Настройка Чата"
description: "Выберите стиль для вашего чата"
type: "chat"

options:
  format: "&7[&6%level%&7] &f%player%&7: &f%message%"
  prefix: "&6[VIP]"

actions:
  format: "chat_format %format%"
  prefix: "chat_prefix %prefix%"
  apply: "chat_apply"
  reset: "chat_reset"
```

#### Пример меню для скорборда (`menus/scoreboard.yml`)

```yaml
title: "Настройка Скорборда"
description: "Выберите стиль для вашего скорборда"
type: "scoreboard"

options:
  title: "&6&lВаш Сервер"
  lines:
    - "&7━━━━━━━━━━━━━━━━━━"
    - "&6Игрок: &f%player%"
    - "&6Уровень: &f%level%"
    - "&6Баланс: &f%balance%"
    - "&7━━━━━━━━━━━━━━━━━━"

actions:
  title: "scoreboard_title %title%"
  lines: "scoreboard_lines %lines%"
  apply: "scoreboard_apply"
  reset: "scoreboard_reset"
```

#### Пример меню для ника (`menus/displayname.yml`)

```yaml
title: "Настройка Ника"
description: "Выберите цвет для вашего ника"
type: "displayname"

options:
  prefix: "&6[VIP]"
  suffix: "&7[Level %level%]"
  color: "&f"

actions:
  prefix: "displayname_prefix %prefix%"
  suffix: "displayname_suffix %suffix%"
  color: "displayname_color %color%"
  apply: "displayname_apply"
  reset: "displayname_reset"
```

#### Пример меню для титулов (`menus/title.yml`)

```yaml
title: "Настройка Титулов"
description: "Выберите титул для вашего игрока"
type: "title"

options:
  default_title: "Игрок"
  default_prefix: "&7[Игрок]"

actions:
  set_title: "title_set %title% %prefix%"
  apply: "title_apply"
  reset: "title_reset"
```

#### Пример меню для дистанции видимости (`menus/viewdistance.yml`)

```yaml
title: "Настройка Дистанции Видимости"
description: "Выберите максимальную дистанцию видимости (8-24 чанка)"
type: "viewdistance"

options:
  default_distance: 12
  min_distance: 8
  max_distance: 24

actions:
  set_distance: "viewdistance_set %distance%"
  apply: "viewdistance_apply"
  reset: "viewdistance_reset"
```

### Создание пользовательского меню

Создайте новый файл в папке `menus/` с расширением `.yml`:

```yaml
title: "Мое Пользовательское Меню"
description: "Описание меню"
type: "custom"

buttons:
  - "Кнопка 1:action1:RED"
  - "Кнопка 2:action2:GREEN"
  - "Кнопка 3:action3:BLUE"

actions:
  action1: "say Вы нажали кнопку 1!"
  action2: "say Вы нажали кнопку 2!"
  action3: "say Вы нажали кнопку 3!"
  apply: "say Настройки применены!"
  reset: "say Настройки сброшены!"
```

## Использование

1. **Открытие меню для себя:**
   ```
   /customui tab
   /customui chat
   /customui scoreboard
   /customui displayname
   /customui title
   /customui viewdistance
   ```

2. **Открытие меню для другого игрока:**
   ```
   /customui tab PlayerName
   /customui chat PlayerName
   ```

3. **Просмотр доступных меню:**
   ```
   /customui list
   ```

4. **Перезагрузка конфигурации:**
   ```
   /customui reload
   ```

## Поддерживаемые плейсхолдеры

### Основные плейсхолдеры игрока

- `%customui_player_name%` - имя игрока
- `%customui_player_displayname%` - отображаемое имя игрока
- `%customui_player_uuid%` - UUID игрока
- `%customui_player_world%` - мир игрока
- `%customui_player_health%` - здоровье игрока
- `%customui_player_max_health%` - максимальное здоровье игрока
- `%customui_player_food%` - сытость игрока
- `%customui_player_level%` - уровень игрока
- `%customui_player_exp%` - опыт игрока
- `%customui_player_gamemode%` - режим игры игрока
- `%customui_player_ping%` - пинг игрока
- `%customui_player_view_distance%` - дистанция видимости игрока

### LuckPerms плейсхолдеры

- `%customui_luckperms_prefix%` - префикс игрока
- `%customui_luckperms_suffix%` - суффикс игрока
- `%customui_luckperms_primary_group%` - основная группа игрока
- `%customui_luckperms_groups%` - все группы игрока
- `%customui_luckperms_weight%` - вес группы игрока
- `%customui_luckperms_meta_[ключ]%` - мета-данные игрока
- `%customui_luckperms_permission_[право]%` - проверка права игрока

### Серверные плейсхолдеры

- `%customui_server_name%` - имя сервера
- `%customui_server_version%` - версия сервера
- `%customui_server_online%` - количество онлайн игроков
- `%customui_server_max_players%` - максимальное количество игроков
- `%customui_server_tps%` - TPS сервера
- `%customui_server_uptime%` - время работы сервера

### Плейсхолдеры времени

- `%customui_time_hour%` - час
- `%customui_time_minute%` - минута
- `%customui_time_second%` - секунда
- `%customui_date_year%` - год
- `%customui_date_month%` - месяц
- `%customui_date_day%` - день
- `%customui_date_day_of_week%` - день недели

### Плейсхолдеры меню

- `%customui_menu_count%` - количество доступных меню
- `%customui_menu_list%` - список доступных меню

## Примеры использования плейсхолдеров

### В конфигурации меню

```yaml
# Пример использования в меню таба
options:
  header: "&6&l%customui_server_name%"
  footer: "&7Игрок: &f%customui_player_name% &7| Онлайн: &f%customui_server_online%/%customui_server_max_players%"

# Пример использования в меню чата
options:
  format: "&7[&6%customui_luckperms_prefix%&7] &f%customui_player_name%&7: &f%message%"

# Пример использования в меню скорборда
options:
  title: "&6&l%customui_server_name%"
  lines:
    - "&7━━━━━━━━━━━━━━━━━━"
    - "&6Игрок: &f%customui_player_name%"
    - "&6Ранг: &f%customui_luckperms_primary_group%"
    - "&6Уровень: &f%customui_player_level%"
    - "&6Здоровье: &f%customui_player_health%/%customui_player_max_health%"
    - "&6Пинг: &f%customui_player_ping%ms"
    - "&7━━━━━━━━━━━━━━━━━━"
```

### В командах

```yaml
actions:
  set_prefix: "lp user %customui_player_name% meta setprefix \"%prefix%\""
  check_permission: "if %customui_luckperms_permission_customui.admin% then say Вы администратор!"
```

## Требования

- **Paper 1.21.7+** - сервер с поддержкой Dialog API
- **Java 21+** - для компиляции и запуска
- **Minecraft 1.21+** - версия игры

### Опциональные зависимости

- **PlaceholderAPI 2.11.6+** - для расширенной поддержки плейсхолдеров
- **LuckPerms 5.4+** - для интеграции с системой прав и групп
- **Vault** - для интеграции с экономическими плагинами
- **EssentialsX** - для дополнительных плейсхолдеров

## Сборка

```bash
mvn clean package
```

Готовый плагин будет в файле `target/CustomUI-1.0.0.jar`

## Поддержка

Если у вас возникли вопросы или проблемы:

1. Проверьте логи сервера на наличие ошибок
2. Убедитесь, что используется Paper 1.21.7+
3. Проверьте права доступа игроков
4. Убедитесь в корректности конфигурации

## Лицензия

Этот плагин распространяется под лицензией MIT. См. файл `LICENSE` для подробностей.