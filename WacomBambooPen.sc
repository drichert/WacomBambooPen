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
  }

  createBuses { arg server;
    device[\x].createBus(server);
    device[\y].createBus(server);
    device[\z].createBus(server);
  }

  // Assign each bus to an instance var
  x { ^device[\x].bus }
  y { ^device[\y].bus }
  z { ^device[\z].bus }
}
