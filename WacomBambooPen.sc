WacomBambooPen {
  var <device
  ;

  *new {
    GeneralHID.buildDeviceList;
    ^super.new.init
  }

  init { arg server;
    this.get_device;
    this.assignNames;
    this.createBuses;
  }

  get_device {
    device = GeneralHID.open(
      // Wacom Bamboo Pen specific
      GeneralHID.findBy(1386, 212, nil, 262)
    );
    device.grab
  }

  assignNames {
    device.add(\x, [3, 0]);
    device.add(\y, [3, 1]);
    device.add(\z, [3, 24]);
    device.add(\b1, [1, 331]);
    device.add(\b2, [1, 332]);
    device.add(\hover, [1, 320]);
    device.add(\touch, [1, 330]);
    // device.add(\unknown, [1, 321]);
  }

  createBuses { arg server;
    device[\x].createBus(server);
    device[\y].createBus(server);
    device[\z].createBus(server);
    device[\b1].createBus(server);
    device[\b2].createBus(server);
    device[\hover].createBus(server);
    device[\touch].createBus(server);
  }

  // Assign each bus to an instance var
  x     { ^device[\x].bus }
  y     { ^device[\y].bus }
  z     { ^device[\z].bus }
  b1    { ^device[\b1].bus }
  b2    { ^device[\b2].bus }
  hover { ^device[\hover].bus }
  touch { ^device[\touch].bus }
}
