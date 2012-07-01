# WacomBambooPen

SuperCollider class for handling input from a Wacom Bamboo Pen tablet

## Usage

```
// s is the default server (used for creating control buses)
w = WacomBambooPen.new(s)

// Get control bus for x-axis
w.x
// Get control bus for z-axis (pressure)
w.z

// Map y-axis to freq of some synth
x = Synth(\whatev);
x.map(\freq, w.y)
```
## Notes

### Ubuntu 
You may need to remove package `xserver-xorg-input-wacom`  

If you're seeing "ERROR: LID (1): Permission denied" errors, try adding these udev rules in 
/etc/udev/rules/98-supercollider-lid.rules (adjust filename and `GROUP` setting accordingly).
```
KERNEL=="event[0-9]*", NAME="input/%k", GROUP="audio"
KERNEL=="event[0-9]*", MODE="0660"
```
