# WacomBambooPen

SuperCollider class for handling input from a Wacom Bamboo Pen tablet

### Usage

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
### Notes

Ubuntu 11.04 - must remove xserver-xorg-input-wacom
