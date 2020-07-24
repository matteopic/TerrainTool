# TerrainTool - create surface topographic data for Survex and Therion

This project has been forked from https://git.sr.ht/~kravietz/TerrainTool

TerrainTool is used to create surface topographic data for the cave survey packages [Survex](http://survex.com) and [Therion](http://therion.speleo.sk).
This uses the results of the [Shuttle Radar Topography Mission](http://www2.jpl.nasa.gov/srtm/)</a> (SRTM) in which the shuttle _Endeavour_ mapped the height of
the Earth's surface between the latitudes 60 degrees North and 56 degrees South - about 80% of the Earth's land mass. Resolution was 1 arc-second for the US and its territories
and 3 arc-seconds elsewhere. The latter corresponds to about 90m at the equator. The resulting data is royalty-free and, for many countries, may be the only data publicly available.
More recently, the [Advanced Spaceborne Thermal Emission and Reflection Radiometer (ASTER)](http://www.jpl.nasa.gov/news/news.cfm?release=2009-103) project
has published data at 1 arc-second resolution for the land masses between 83 degrees North and 83 degrees South and is also royalty-free. Whilst the SRTM data contains numerous "voids"
caused by shadowing in steep or mountainous areas, the ASTER data was built from stereo images taken over a much longer period of time and as a result is much more complete. It does,
however, suffer from "artefacts" - spurious features which are by-products of the imaging process.

SRTM data is available to all on the Internet from a NASA server and TerrainTool automatically fetches anything it needs. The mechanism for accessing ASTER data is
slightly more complicated in that users need to register first on the US or Japanese website and then "order" (at no cost) the files that they need. A few minutes later, the system sends
the user an e-mail containing a link to a zip file containing the relevant files. This can be downloaded via FTP or using a standard web browser. A zip file containing the tiles for the
UK and Ireland, for example, was a little over 500MB. Unfortunately, it's not possible for a tool like TerrainTool to take care of the downloading of ASTER data automatically. More
instructions on how to do this manually can be found <a href="#Installing_ASTER_data_files">below</a>.

TerrainTool does the following:
* Automatically downloads SRTM data from the NASA ftp site as needed.
* Converts between spherical (Lat/Lon) coordinates and a variety of map coordinates. Coordinate systems currently supported include British (OSGB) grid, Irish grid,
  UTM, French (Lambert conical projections) and Austrian. Additional mapping systems can be added quite easily.
* Re-samples the data using bilinear interpolation to create a rectangular mesh of user-specified spacing.
* Displays a coloured topographic map of the mesh.
* Adds a user-specified offset (3-D) to the coordinates to align with coordinates used for the underground survey.
* Saves the mesh as surface data in Survex (.svx) or Therion (.th) format.

The programme, written in Java, provides a conventional GUI-style interface&nbsp;and will run under Windows, Solaris macOS and Linux operating systems. The latest Java
Runtime is required and can be downloaded free of charge from <a href=
                                                                                          "http://www.oracle.com/technetwork/java/javase/downloads/index.html">Oracle</a>. 
	Mac users should note that the JRE needs to be at least version 7 and that the legacy version 6 implementation provided by Apple is no longer sufficient.


"TerrainTool" was written by Mike McCombe who is very grateful to UBSS for giving it a home. Please feel free to contact Mike with feedback or requests for help at
mikemccombe &lt;at&gt; btinternet.com or via the <a href="http://survex.com/maillist.html">Survex list</a>.


## Installation

Sorry, there's no fancy package installer but as there's only one file it should be pretty straightforward.

* If you don't already have the Java Standard Edition (SE) installed, [download](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
   it from the Oracle
  website now. Unless you plan to develop your own Java software, the Java Runtime Environment (JRE) will suffice.
* <a href="TerrainTool.jar">Download the TerrainTool</a> "jar". Internet Explorer users may find that the file that arrives is called TerrainTool.zip. If this happens,
  just rename it to be TerrainTool.jar. Do not try unpacking the ZIP file! I suggest you save it in its own directory. When you first run the programme, it will create
  "terraintool.properties" (in the same directory) and a subdirectory called "data".
* Double-clicking the jar file should start the programme. If you need to start it from a command line interface, try "java -jar TerrainTool.jar".

Thanks to Wookey, Terraintool is available in Debian 7 ('Wheezy') or Ubuntu 12.04 ('Precise Pangolin') onwards. To install it select 'terraintool' in your favourite package manager (Upgrade Center, Synaptic, Aptitude) and install it. 

On the command line do 

    sudo apt-get install terraintool

If your system has a firewall, you <i>may</i> need to tell it to allow java to have outgoing ftp access. Otherwise, it won't be able to download the data files from the
NASA site. This version of TerrainTool doesn't support Internet access via a proxy. I can easily add this if anyone wants it - but I have no means of testing it.

## Driving Instructions

TerrainTool is a conventional GUI-based application with a menu bar and dialog boxes to gather user-information. To get started, do the following:

* Select the required <a href="#Region">region</a> and <a href="#Coordinates">coordinate system</a> using the Options menu
* Go to <a href="#Create">Create</a> on the File menu to specify the size, location and resolution of the mesh.
* <a href="#Save_as">Save</a> the results as in Survex (.svx) or Therion (.th) format
* Use Survex to process the file and Aven to view the results in 3D. Remember to enable viewing of surface legs in Aven!
* Use the Offset command in the Options menu to fully align the terrain data with the coordinates used in your survey.
* When generating surface data in Therion format, Therion needs to be told the coordinate system used for the surface data in a form that it recognises (e.g. EPSG:27700).
* See the description of the surface command in the Therion Book for more details. 
* Incorporate the terrain data into your survey project.

### File Menu
            <p>
**Create...*** is used to calculate the terrain mesh. A dialog box is used to gather the following:-

<table class="ubsstable">
<tr>
<th>
Item
</th>
<th>
Meaning
</th>
</tr>
<tr>
<td>
Grid Reference
</td>
<td>
The grid reference for the mesh, expressed in the current coordinate type. This point can be at the centre of the mesh, any of the corners or the mid-point of ant of the sides
(see below). An example in the correct format is shown below the text field.
</td>
</tr>
<tr class="altRow">
<td>
E-W Range
</td>
<td>
The distance (in metres) between the East and West edges of the mesh.
</td>
</tr>
<tr>
<td>
N-S Range
</td>
<td>
The distance (in metres) between the North and South edges of the mesh.
</td>
</tr>
<tr class="altRow">
<td>
Spacing
</td>
<td>
The distance (in metres) between adjacent cells in the mesh.
</td>
</tr>
<tr>
<td>
Grid ref is at
</td>
<td>
Specifies where current point (see "Grid Reference" above) lies in relation to the boundaries of the mesh.
</td>
</tr>
</table>


Pressing <strong>OK</strong> starts the calculation of the mesh points. If "Auto-download" is enabled, data files will be downloaded as needed from the Nasa ftp site. These are
stored in the "data" subdirectory for later re-use if necessary, avoiding the need to download the same file again.

At the end of the calculation, results are displayed as a simple coloured relief map. The mouse position is displayed (in current coordinates) in the message bar on the
bottom edge of the frame.

**Lat/Long...** provides a means of defining the current point in terms of latitude and longitude, rather than as a grid reference. If the point can be represented
as a valid grid reference in the current coordinate system, it is used to initialise the "Grid Reference" field of the "Create..." dialog box. Likewise, the current grid reference is used
to initialise the Lat and Long fields with the latitude and longitude of the current point.

Latitude and longitude values can be expressed as either:

* real values in degrees (e.g. 46.25), where negative values are West / South, or
* values in degrees, minutes and seconds (e.g. 46 N 15' 22.6")

Latitude and Longitude are usually based on the WGS-84/GRS-80 datum and ellipsoid. The user may select alternatives,
which will cause the lat and long values to be re-calculated.

**Save as...**

Once a mesh has been calculated, the "Save as..." command can be used to save the terrain data. Normally, this will be in Survex (`.svx`)  or Therion (`.th`) format. Occasionally, there may
be missing values (known as "voids") in the SRTM data - particularly in mountainous areas where steep faces may have been hidden from the Shuttle's line of sight. Generally, TerrainTool
will "repair" individual voids by interpolating from the surrounding cells. However, if this isn't possible, gaps are left in the mesh where no data is available.

Otherwise, height values are defined for each point in the mesh. Easting and Northing values are those of the current coordinate system.


### Options Menu

#### Coordinates...

This is used to select the type of coordinates to use. The following are currently supported:

<table class="ubbsstable">
<tr>
<th>
Coordinate System
</th>
<th> </th>
</tr>
<tr>
<td>
Austrian
</td>
<td>
The Austrian (BMN) coordinate system, in three zones
</td>
</tr>
<tr class="altRow">
<td>
Irish Grid
</td>
<td>
The Irish grid system, used in both Northern Ireland and the Republic of Ireland.
</td>
</tr>
<tr>
<td>
Lambert 93
</td>
<td>
The Lambert 93 coordinate system. A conformal conical projection occasionally used in France.
</td>
</tr>
<tr class="altRow">
<td>
Lambert (5 zones)
</td>
<td>
The coordinate system most commonly used in France. Three zones (I, II and III) cover North, Central and Southern France. Zone IV is used in Corsica. A fifth zone (II-extended)
covers the whole of France, at the expense of greater distortion.
</td>
</tr>
<tr>
<td>
NZMG
</td>
<td>
New Zealand Map Grid - New Zealand’s coordinate system superseded in 2010. Maps based on this are no longer available, but still widely used. Based on a conformal orthomorphic projection.
</td>
</tr>
<tr class="altRow">
<td>
NZTM2000
</td>
<td>
New Zealand Transverse Mercator, successor to NZMG. 
</td>
</tr>
<tr>
<td>
OSGB
</td>
<td>
Ordnance Survey of Great Britain - the normal British grid system.
</td>
</tr>
<tr class="altRow">
<td>
UTM
</td>
<td>
Universal Transverse Mercator, devised by the US Department of Defense to cover the globe (except polar regions) in 60 zones. Also used by many national mapping agencies, often
with a national or regional datum instead of WGS84.
</td>
</tr>
</table>

One of the design objectives of this software is to be able to add further coordinate systems with minimal difficulty.

Selecting a coordinate system from the drop-down list results in automatic selection of sensible defaults for the datum and ellipsoid. The user is free to override this
selection using the other two drop-down lists. Whilst, for example, OSGB invariably uses its own datum and the "Airy Sphere", other systems are frequently used with a variety of datums.
UTM, for example, is used in Spain with the European (1950) Datum and Australia with their own (MGI) datum.

#### Auto download

Enables/disables the automatic downloading of data from the NASA SRTM site.

#### Region

The SRTM data site is organised into six regions - Africa, Australia, Eurasia, North_America, South_America and Islands (New Zealand and islands of the Pacific). As I
don't have a simple method of determining the region automatically from lat/lon, you will need to manually select the right region.

#### Offset

This provides a simple way of adding a fixed 3-D offset to mesh point in the mesh as it is saved. You might want to do this because

* Your cave survey coordinates might not use the full easting and northing values
* The height values differ from "known" surface heights in your survey. SRTM heights are referenced to EGM96 (Earth Geopotential Model 1996) and may be significantly
  offset from a national height datum.

#### SRTM Only

Creates terrain using only SRTM data. Any "voids" which cannot be filled by interpolation will result in gaps in the output data. If auto-download is selected and there
is an Internet connction, missing tiles will be automatically downloaded from the NASA server.


#### ASTER Only

Creates terrain using only ASTER data. This has higher resolution and greater coverage than SRTM data but must
be manually downloaded and installed (<a href="#Installing_ASTER_data_files">see below</a>). Its greater resolution
causes TerrainTool to run more slowly than with SRTM data. The end-result may show signs of "artefacts"  - 
spuriousfeatures produced by the imaging process.

#### SRTM plus ASTER

Uses ASTER to fill any "voids" in the SRTM data. This option minimises the processing time and "artefact" penalties of using ASTER data whilst leaving the least number
of voids in the finished product.

#### Legacy ASTER Data

By default, version 1.11 onwards of TerrainTool assumes ASTER data to be from the ASTER 2 dataset. This contains fewer artefacts than the 
original ASTER dataset. However, if you need to use the original data files, select this option.

#### NASADEM

Use this option if you have downloaded and installed NASADEM files. See below for details.

## Installing ASTER data files

Obtaining ASTER data is free and quite straightforward. The first step is that you will need to register at [NASA Earth Data](https://search.earthdata.nasa.gov/)
website. When you've logged in you can use the map tool to draw a square you're interested in and then search for "ASTER"
to refine results to ASTER files ("granules") only. You can then download ZIP files with names like `ASTGTMV003_N43E043.zip`.

When TerrainTool runs it will create a directory called `.terraintool` in your home directory. Place the original
ZIP files in that directory (do _not_ unpack them).

NASADEM works in the same way, use `NASADEM` as search term then download the zip file (e.g. NASADEM_HGT_n56e143.zip) 
finally copy it into the `.terraintool` directory.

A similar procedure can be used to install SRTM data files manually. Simply copy data tiles (e.g. N51W003.hgt.zip) into the "data" sub-directory.




## Author

Copyright (c) 2008 - 2017 Mike McCombe
