/*
 * TerrainFrame.java
 *
 * Version 1.02 17th July 2009
 *      Fixes problems with parsing numbers in locales other than UK and US
 * 
 * Please take time to read the licence terms below:-
 *

 GNU GENERAL PUBLIC LICENSE
 Version 3, 29 June 2007

 Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
 Everyone is permitted to copy and distribute verbatim copies
 of this license document, but changing it is not allowed.

 Preamble

 The GNU General Public License is a free, copyleft license for
 software and other kinds of works.

 The licenses for most software and other practical works are designed
 to take away your freedom to share and change the works.  By contrast,
 the GNU General Public License is intended to guarantee your freedom to
 share and change all versions of a program--to make sure it remains free
 software for all its users.  We, the Free Software Foundation, use the
 GNU General Public License for most of our software; it applies also to
 any other work released this way by its authors.  You can apply it to
 your programs, too.

 When we speak of free software, we are referring to freedom, not
 price.  Our General Public Licenses are designed to make sure that you
 have the freedom to distribute copies of free software (and charge for
 them if you wish), that you receive source code or can get it if you
 want it, that you can change the software or use pieces of it in new
 free programs, and that you know you can do these things.

 To protect your rights, we need to prevent others from denying you
 these rights or asking you to surrender the rights.  Therefore, you have
 certain responsibilities if you distribute copies of the software, or if
 you modify it: responsibilities to respect the freedom of others.

 For example, if you distribute copies of such a program, whether
 gratis or for a fee, you must pass on to the recipients the same
 freedoms that you received.  You must make sure that they, too, receive
 or can get the source code.  And you must show them these terms so they
 know their rights.

 Developers that use the GNU GPL protect your rights with two steps:
 (1) assert copyright on the software, and (2) offer you this License
 giving you legal permission to copy, distribute and/or modify it.

 For the developers' and authors' protection, the GPL clearly explains
 that there is no warranty for this free software.  For both users' and
 authors' sake, the GPL requires that modified versions be marked as
 changed, so that their problems will not be attributed erroneously to
 authors of previous versions.

 Some devices are designed to deny users access to install or run
 modified versions of the software inside them, although the manufacturer
 can do so.  This is fundamentally incompatible with the aim of
 protecting users' freedom to change the software.  The systematic
 pattern of such abuse occurs in the area of products for individuals to
 use, which is precisely where it is most unacceptable.  Therefore, we
 have designed this version of the GPL to prohibit the practice for those
 products.  If such problems arise substantially in other domains, we
 stand ready to extend this provision to those domains in future versions
 of the GPL, as needed to protect the freedom of users.

 Finally, every program is threatened constantly by software patents.
 States should not allow patents to restrict development and use of
 software on general-purpose computers, but in those that do, we wish to
 avoid the special danger that patents applied to a free program could
 make it effectively proprietary.  To prevent this, the GPL assures that
 patents cannot be used to render the program non-free.

 The precise terms and conditions for copying, distribution and
 modification follow.

 TERMS AND CONDITIONS

 0. Definitions.

 "This License" refers to version 3 of the GNU General Public License.

 "Copyright" also means copyright-like laws that apply to other kinds of
 works, such as semiconductor masks.

 "The Program" refers to any copyrightable work licensed under this
 License.  Each licensee is addressed as "you".  "Licensees" and
 "recipients" may be individuals or organizations.

 To "modify" a work means to copy from or adapt all or part of the work
 in a fashion requiring copyright permission, other than the making of an
 exact copy.  The resulting work is called a "modified version" of the
 earlier work or a work "based on" the earlier work.

 A "covered work" means either the unmodified Program or a work based
 on the Program.

 To "propagate" a work means to do anything with it that, without
 permission, would make you directly or secondarily liable for
 infringement under applicable copyright law, except executing it on a
 computer or modifying a private copy.  Propagation includes copying,
 distribution (with or without modification), making available to the
 public, and in some countries other activities as well.

 To "convey" a work means any kind of propagation that enables other
 parties to make or receive copies.  Mere interaction with a user through
 a computer network, with no transfer of a copy, is not conveying.

 An interactive user interface displays "Appropriate Legal Notices"
 to the extent that it includes a convenient and prominently visible
 feature that (1) displays an appropriate copyright notice, and (2)
 tells the user that there is no warranty for the work (except to the
 extent that warranties are provided), that licensees may convey the
 work under this License, and how to view a copy of this License.  If
 the interface presents a list of user commands or options, such as a
 menu, a prominent item in the list meets this criterion.

 1. Source Code.

 The "source code" for a work means the preferred form of the work
 for making modifications to it.  "Object code" means any non-source
 form of a work.

 A "Standard Interface" means an interface that either is an official
 standard defined by a recognized standards body, or, in the case of
 interfaces specified for a particular programming language, one that
 is widely used among developers working in that language.

 The "System Libraries" of an executable work include anything, other
 than the work as a whole, that (a) is included in the normal form of
 packaging a Major Component, but which is not part of that Major
 Component, and (b) serves only to enable use of the work with that
 Major Component, or to implement a Standard Interface for which an
 implementation is available to the public in source code form.  A
 "Major Component", in this context, means a major essential component
 (kernel, window system, and so on) of the specific operating system
 (if any) on which the executable work runs, or a compiler used to
 produce the work, or an object code interpreter used to run it.

 The "Corresponding Source" for a work in object code form means all
 the source code needed to generate, install, and (for an executable
 work) run the object code and to modify the work, including scripts to
 control those activities.  However, it does not include the work's
 System Libraries, or general-purpose tools or generally available free
 programs which are used unmodified in performing those activities but
 which are not part of the work.  For example, Corresponding Source
 includes interface definition files associated with source files for
 the work, and the source code for shared libraries and dynamically
 linked subprograms that the work is specifically designed to require,
 such as by intimate data communication or control flow between those
 subprograms and other parts of the work.

 The Corresponding Source need not include anything that users
 can regenerate automatically from other parts of the Corresponding
 Source.

 The Corresponding Source for a work in source code form is that
 same work.

 2. Basic Permissions.

 All rights granted under this License are granted for the term of
 copyright on the Program, and are irrevocable provided the stated
 conditions are met.  This License explicitly affirms your unlimited
 permission to run the unmodified Program.  The output from running a
 covered work is covered by this License only if the output, given its
 content, constitutes a covered work.  This License acknowledges your
 rights of fair use or other equivalent, as provided by copyright law.

 You may make, run and propagate covered works that you do not
 convey, without conditions so long as your license otherwise remains
 in force.  You may convey covered works to others for the sole purpose
 of having them make modifications exclusively for you, or provide you
 with facilities for running those works, provided that you comply with
 the terms of this License in conveying all material for which you do
 not control copyright.  Those thus making or running the covered works
 for you must do so exclusively on your behalf, under your direction
 and control, on terms that prohibit them from making any copies of
 your copyrighted material outside their relationship with you.

 Conveying under any other circumstances is permitted solely under
 the conditions stated below.  Sublicensing is not allowed; section 10
 makes it unnecessary.

 3. Protecting Users' Legal Rights From Anti-Circumvention Law.

 No covered work shall be deemed part of an effective technological
 measure under any applicable law fulfilling obligations under article
 11 of the WIPO copyright treaty adopted on 20 December 1996, or
 similar laws prohibiting or restricting circumvention of such
 measures.

 When you convey a covered work, you waive any legal power to forbid
 circumvention of technological measures to the extent such circumvention
 is effected by exercising rights under this License with respect to
 the covered work, and you disclaim any intention to limit operation or
 modification of the work as a means of enforcing, against the work's
 users, your or third parties' legal rights to forbid circumvention of
 technological measures.

 4. Conveying Verbatim Copies.

 You may convey verbatim copies of the Program's source code as you
 receive it, in any medium, provided that you conspicuously and
 appropriately publish on each copy an appropriate copyright notice;
 keep intact all notices stating that this License and any
 non-permissive terms added in accord with section 7 apply to the code;
 keep intact all notices of the absence of any warranty; and give all
 recipients a copy of this License along with the Program.

 You may charge any price or no price for each copy that you convey,
 and you may offer support or warranty protection for a fee.

 5. Conveying Modified Source Versions.

 You may convey a work based on the Program, or the modifications to
 produce it from the Program, in the form of source code under the
 terms of section 4, provided that you also meet all of these conditions:

 a) The work must carry prominent notices stating that you modified
 it, and giving a relevant date.

 b) The work must carry prominent notices stating that it is
 released under this License and any conditions added under section
 7.  This requirement modifies the requirement in section 4 to
 "keep intact all notices".

 c) You must license the entire work, as a whole, under this
 License to anyone who comes into possession of a copy.  This
 License will therefore apply, along with any applicable section 7
 additional terms, to the whole of the work, and all its parts,
 regardless of how they are packaged.  This License gives no
 permission to license the work in any other way, but it does not
 invalidate such permission if you have separately received it.

 d) If the work has interactive user interfaces, each must display
 Appropriate Legal Notices; however, if the Program has interactive
 interfaces that do not display Appropriate Legal Notices, your
 work need not make them do so.

 A compilation of a covered work with other separate and independent
 works, which are not by their nature extensions of the covered work,
 and which are not combined with it such as to form a larger program,
 in or on a volume of a storage or distribution medium, is called an
 "aggregate" if the compilation and its resulting copyright are not
 used to limit the access or legal rights of the compilation's users
 beyond what the individual works permit.  Inclusion of a covered work
 in an aggregate does not cause this License to apply to the other
 parts of the aggregate.

 6. Conveying Non-Source Forms.

 You may convey a covered work in object code form under the terms
 of sections 4 and 5, provided that you also convey the
 machine-readable Corresponding Source under the terms of this License,
 in one of these ways:

 a) Convey the object code in, or embodied in, a physical product
 (including a physical distribution medium), accompanied by the
 Corresponding Source fixed on a durable physical medium
 customarily used for software interchange.

 b) Convey the object code in, or embodied in, a physical product
 (including a physical distribution medium), accompanied by a
 written offer, valid for at least three years and valid for as
 long as you offer spare parts or customer support for that product
 model, to give anyone who possesses the object code either (1) a
 copy of the Corresponding Source for all the software in the
 product that is covered by this License, on a durable physical
 medium customarily used for software interchange, for a price no
 more than your reasonable cost of physically performing this
 conveying of source, or (2) access to copy the
 Corresponding Source from a network server at no charge.

 c) Convey individual copies of the object code with a copy of the
 written offer to provide the Corresponding Source.  This
 alternative is allowed only occasionally and noncommercially, and
 only if you received the object code with such an offer, in accord
 with subsection 6b.

 d) Convey the object code by offering access from a designated
 place (gratis or for a charge), and offer equivalent access to the
 Corresponding Source in the same way through the same place at no
 further charge.  You need not require recipients to copy the
 Corresponding Source along with the object code.  If the place to
 copy the object code is a network server, the Corresponding Source
 may be on a different server (operated by you or a third party)
 that supports equivalent copying facilities, provided you maintain
 clear directions next to the object code saying where to find the
 Corresponding Source.  Regardless of what server hosts the
 Corresponding Source, you remain obligated to ensure that it is
 available for as long as needed to satisfy these requirements.

 e) Convey the object code using peer-to-peer transmission, provided
 you inform other peers where the object code and Corresponding
 Source of the work are being offered to the general public at no
 charge under subsection 6d.

 A separable portion of the object code, whose source code is excluded
 from the Corresponding Source as a System Library, need not be
 included in conveying the object code work.

 A "User Product" is either (1) a "consumer product", which means any
 tangible personal property which is normally used for personal, family,
 or household purposes, or (2) anything designed or sold for incorporation
 into a dwelling.  In determining whether a product is a consumer product,
 doubtful cases shall be resolved in favor of coverage.  For a particular
 product received by a particular user, "normally used" refers to a
 typical or common use of that class of product, regardless of the status
 of the particular user or of the way in which the particular user
 actually uses, or expects or is expected to use, the product.  A product
 is a consumer product regardless of whether the product has substantial
 commercial, industrial or non-consumer uses, unless such uses represent
 the only significant mode of use of the product.

 "Installation Information" for a User Product means any methods,
 procedures, authorization keys, or other information required to install
 and execute modified versions of a covered work in that User Product from
 a modified version of its Corresponding Source.  The information must
 suffice to ensure that the continued functioning of the modified object
 code is in no case prevented or interfered with solely because
 modification has been made.

 If you convey an object code work under this section in, or with, or
 specifically for use in, a User Product, and the conveying occurs as
 part of a transaction in which the right of possession and use of the
 User Product is transferred to the recipient in perpetuity or for a
 fixed term (regardless of how the transaction is characterized), the
 Corresponding Source conveyed under this section must be accompanied
 by the Installation Information.  But this requirement does not apply
 if neither you nor any third party retains the ability to install
 modified object code on the User Product (for example, the work has
 been installed in ROM).

 The requirement to provide Installation Information does not include a
 requirement to continue to provide support service, warranty, or updates
 for a work that has been modified or installed by the recipient, or for
 the User Product in which it has been modified or installed.  Access to a
 network may be denied when the modification itself materially and
 adversely affects the operation of the network or violates the rules and
 protocols for communication across the network.

 Corresponding Source conveyed, and Installation Information provided,
 in accord with this section must be in a format that is publicly
 documented (and with an implementation available to the public in
 source code form), and must require no special password or key for
 unpacking, reading or copying.

 7. Additional Terms.

 "Additional permissions" are terms that supplement the terms of this
 License by making exceptions from one or more of its conditions.
 Additional permissions that are applicable to the entire Program shall
 be treated as though they were included in this License, to the extent
 that they are valid under applicable law.  If additional permissions
 apply only to part of the Program, that part may be used separately
 under those permissions, but the entire Program remains governed by
 this License without regard to the additional permissions.

 When you convey a copy of a covered work, you may at your option
 remove any additional permissions from that copy, or from any part of
 it.  (Additional permissions may be written to require their own
 removal in certain cases when you modify the work.)  You may place
 additional permissions on material, added by you to a covered work,
 for which you have or can give appropriate copyright permission.

 Notwithstanding any other provision of this License, for material you
 add to a covered work, you may (if authorized by the copyright holders of
 that material) supplement the terms of this License with terms:

 a) Disclaiming warranty or limiting liability differently from the
 terms of sections 15 and 16 of this License; or

 b) Requiring preservation of specified reasonable legal notices or
 author attributions in that material or in the Appropriate Legal
 Notices displayed by works containing it; or

 c) Prohibiting misrepresentation of the origin of that material, or
 requiring that modified versions of such material be marked in
 reasonable ways as different from the original version; or

 d) Limiting the use for publicity purposes of names of licensors or
 authors of the material; or

 e) Declining to grant rights under trademark law for use of some
 trade names, trademarks, or service marks; or

 f) Requiring indemnification of licensors and authors of that
 material by anyone who conveys the material (or modified versions of
 it) with contractual assumptions of liability to the recipient, for
 any liability that these contractual assumptions directly impose on
 those licensors and authors.

 All other non-permissive additional terms are considered "further
 restrictions" within the meaning of section 10.  If the Program as you
 received it, or any part of it, contains a notice stating that it is
 governed by this License along with a term that is a further
 restriction, you may remove that term.  If a license document contains
 a further restriction but permits relicensing or conveying under this
 License, you may add to a covered work material governed by the terms
 of that license document, provided that the further restriction does
 not survive such relicensing or conveying.

 If you add terms to a covered work in accord with this section, you
 must place, in the relevant source files, a statement of the
 additional terms that apply to those files, or a notice indicating
 where to find the applicable terms.

 Additional terms, permissive or non-permissive, may be stated in the
 form of a separately written license, or stated as exceptions;
 the above requirements apply either way.

 8. Termination.

 You may not propagate or modify a covered work except as expressly
 provided under this License.  Any attempt otherwise to propagate or
 modify it is void, and will automatically terminate your rights under
 this License (including any patent licenses granted under the third
 paragraph of section 11).

 However, if you cease all violation of this License, then your
 license from a particular copyright holder is reinstated (a)
 provisionally, unless and until the copyright holder explicitly and
 finally terminates your license, and (b) permanently, if the copyright
 holder fails to notify you of the violation by some reasonable means
 prior to 60 days after the cessation.

 Moreover, your license from a particular copyright holder is
 reinstated permanently if the copyright holder notifies you of the
 violation by some reasonable means, this is the first time you have
 received notice of violation of this License (for any work) from that
 copyright holder, and you cure the violation prior to 30 days after
 your receipt of the notice.

 Termination of your rights under this section does not terminate the
 licenses of parties who have received copies or rights from you under
 this License.  If your rights have been terminated and not permanently
 reinstated, you do not qualify to receive new licenses for the same
 material under section 10.

 9. Acceptance Not Required for Having Copies.

 You are not required to accept this License in order to receive or
 run a copy of the Program.  Ancillary propagation of a covered work
 occurring solely as a consequence of using peer-to-peer transmission
 to receive a copy likewise does not require acceptance.  However,
 nothing other than this License grants you permission to propagate or
 modify any covered work.  These actions infringe copyright if you do
 not accept this License.  Therefore, by modifying or propagating a
 covered work, you indicate your acceptance of this License to do so.

 10. Automatic Licensing of Downstream Recipients.

 Each time you convey a covered work, the recipient automatically
 receives a license from the original licensors, to run, modify and
 propagate that work, subject to this License.  You are not responsible
 for enforcing compliance by third parties with this License.

 An "entity transaction" is a transaction transferring control of an
 organization, or substantially all assets of one, or subdividing an
 organization, or merging organizations.  If propagation of a covered
 work results from an entity transaction, each party to that
 transaction who receives a copy of the work also receives whatever
 licenses to the work the party's predecessor in interest had or could
 give under the previous paragraph, plus a right to possession of the
 Corresponding Source of the work from the predecessor in interest, if
 the predecessor has it or can get it with reasonable efforts.

 You may not impose any further restrictions on the exercise of the
 rights granted or affirmed under this License.  For example, you may
 not impose a license fee, royalty, or other charge for exercise of
 rights granted under this License, and you may not initiate litigation
 (including a cross-claim or counterclaim in a lawsuit) alleging that
 any patent claim is infringed by making, using, selling, offering for
 sale, or importing the Program or any portion of it.

 11. Patents.

 A "contributor" is a copyright holder who authorizes use under this
 License of the Program or a work on which the Program is based.  The
 work thus licensed is called the contributor's "contributor version".

 A contributor's "essential patent claims" are all patent claims
 owned or controlled by the contributor, whether already acquired or
 hereafter acquired, that would be infringed by some manner, permitted
 by this License, of making, using, or selling its contributor version,
 but do not include claims that would be infringed only as a
 consequence of further modification of the contributor version.  For
 purposes of this definition, "control" includes the right to grant
 patent sublicenses in a manner consistent with the requirements of
 this License.

 Each contributor grants you a non-exclusive, worldwide, royalty-free
 patent license under the contributor's essential patent claims, to
 make, use, sell, offer for sale, import and otherwise run, modify and
 propagate the contents of its contributor version.

 In the following three paragraphs, a "patent license" is any express
 agreement or commitment, however denominated, not to enforce a patent
 (such as an express permission to practice a patent or covenant not to
 sue for patent infringement).  To "grant" such a patent license to a
 party means to make such an agreement or commitment not to enforce a
 patent against the party.

 If you convey a covered work, knowingly relying on a patent license,
 and the Corresponding Source of the work is not available for anyone
 to copy, free of charge and under the terms of this License, through a
 publicly available network server or other readily accessible means,
 then you must either (1) cause the Corresponding Source to be so
 available, or (2) arrange to deprive yourself of the benefit of the
 patent license for this particular work, or (3) arrange, in a manner
 consistent with the requirements of this License, to extend the patent
 license to downstream recipients.  "Knowingly relying" means you have
 actual knowledge that, but for the patent license, your conveying the
 covered work in a country, or your recipient's use of the covered work
 in a country, would infringe one or more identifiable patents in that
 country that you have reason to believe are valid.

 If, pursuant to or in connection with a single transaction or
 arrangement, you convey, or propagate by procuring conveyance of, a
 covered work, and grant a patent license to some of the parties
 receiving the covered work authorizing them to use, propagate, modify
 or convey a specific copy of the covered work, then the patent license
 you grant is automatically extended to all recipients of the covered
 work and works based on it.

 A patent license is "discriminatory" if it does not include within
 the scope of its coverage, prohibits the exercise of, or is
 conditioned on the non-exercise of one or more of the rights that are
 specifically granted under this License.  You may not convey a covered
 work if you are a party to an arrangement with a third party that is
 in the business of distributing software, under which you make payment
 to the third party based on the extent of your activity of conveying
 the work, and under which the third party grants, to any of the
 parties who would receive the covered work from you, a discriminatory
 patent license (a) in connection with copies of the covered work
 conveyed by you (or copies made from those copies), or (b) primarily
 for and in connection with specific products or compilations that
 contain the covered work, unless you entered into that arrangement,
 or that patent license was granted, prior to 28 March 2007.

 Nothing in this License shall be construed as excluding or limiting
 any implied license or other defenses to infringement that may
 otherwise be available to you under applicable patent law.

 12. No Surrender of Others' Freedom.

 If conditions are imposed on you (whether by court order, agreement or
 otherwise) that contradict the conditions of this License, they do not
 excuse you from the conditions of this License.  If you cannot convey a
 covered work so as to satisfy simultaneously your obligations under this
 License and any other pertinent obligations, then as a consequence you may
 not convey it at all.  For example, if you agree to terms that obligate you
 to collect a royalty for further conveying from those to whom you convey
 the Program, the only way you could satisfy both those terms and this
 License would be to refrain entirely from conveying the Program.

 13. Use with the GNU Affero General Public License.

 Notwithstanding any other provision of this License, you have
 permission to link or combine any covered work with a work licensed
 under version 3 of the GNU Affero General Public License into a single
 combined work, and to convey the resulting work.  The terms of this
 License will continue to apply to the part which is the covered work,
 but the special requirements of the GNU Affero General Public License,
 section 13, concerning interaction through a network will apply to the
 combination as such.

 14. Revised Versions of this License.

 The Free Software Foundation may publish revised and/or new versions of
 the GNU General Public License from time to time.  Such new versions will
 be similar in spirit to the present version, but may differ in detail to
 address new problems or concerns.

 Each version is given a distinguishing version number.  If the
 Program specifies that a certain numbered version of the GNU General
 Public License "or any later version" applies to it, you have the
 option of following the terms and conditions either of that numbered
 version or of any later version published by the Free Software
 Foundation.  If the Program does not specify a version number of the
 GNU General Public License, you may choose any version ever published
 by the Free Software Foundation.

 If the Program specifies that a proxy can decide which future
 versions of the GNU General Public License can be used, that proxy's
 public statement of acceptance of a version permanently authorizes you
 to choose that version for the Program.

 Later license versions may give you additional or different
 permissions.  However, no additional obligations are imposed on any
 author or copyright holder as a result of your choosing to follow a
 later version.

 15. Disclaimer of Warranty.

 THERE IS NO WARRANTY FOR THE PROGRAM, TO THE EXTENT PERMITTED BY
 APPLICABLE LAW.  EXCEPT WHEN OTHERWISE STATED IN WRITING THE COPYRIGHT
 HOLDERS AND/OR OTHER PARTIES PROVIDE THE PROGRAM "AS IS" WITHOUT WARRANTY
 OF ANY KIND, EITHER EXPRESSED OR IMPLIED, INCLUDING, BUT NOT LIMITED TO,
 THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 PURPOSE.  THE ENTIRE RISK AS TO THE QUALITY AND PERFORMANCE OF THE PROGRAM
 IS WITH YOU.  SHOULD THE PROGRAM PROVE DEFECTIVE, YOU ASSUME THE COST OF
 ALL NECESSARY SERVICING, REPAIR OR CORRECTION.

 16. Limitation of Liability.

 IN NO EVENT UNLESS REQUIRED BY APPLICABLE LAW OR AGREED TO IN WRITING
 WILL ANY COPYRIGHT HOLDER, OR ANY OTHER PARTY WHO MODIFIES AND/OR CONVEYS
 THE PROGRAM AS PERMITTED ABOVE, BE LIABLE TO YOU FOR DAMAGES, INCLUDING ANY
 GENERAL, SPECIAL, INCIDENTAL OR CONSEQUENTIAL DAMAGES ARISING OUT OF THE
 USE OR INABILITY TO USE THE PROGRAM (INCLUDING BUT NOT LIMITED TO LOSS OF
 DATA OR DATA BEING RENDERED INACCURATE OR LOSSES SUSTAINED BY YOU OR THIRD
 PARTIES OR A FAILURE OF THE PROGRAM TO OPERATE WITH ANY OTHER PROGRAMS),
 EVEN IF SUCH HOLDER OR OTHER PARTY HAS BEEN ADVISED OF THE POSSIBILITY OF
 SUCH DAMAGES.

 17. Interpretation of Sections 15 and 16.

 If the disclaimer of warranty and limitation of liability provided
 above cannot be given local legal effect according to their terms,
 reviewing courts shall apply local law that most closely approximates
 an absolute waiver of all civil liability in connection with the
 Program, unless a warranty or assumption of liability accompanies a
 copy of the Program in return for a fee.

 END OF TERMS AND CONDITIONS

 * Created on 19 January 2008, 16:04
 */
package mccombe.terrain;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.TimeZone;
import java.util.concurrent.ExecutionException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.UnsupportedLookAndFeelException;
import mccombe.mapping.*;
import mccombe.util.*;

/**
 *
 * @author Mike
 */
public class TerrainFrame extends javax.swing.JFrame {

    /**
     * Creates new form TerrainFrame
     */
    public TerrainFrame() {
        initComponents();

        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        }
        // status bar initialization - message timeout, idle icon and busy animation, etc
        int messageTimeout = 1000;

        messageTimer = new Timer(messageTimeout, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                eraseMessage();
            }
        });
        messageTimer.setRepeats(false);

        int busyAnimationRate = 30;
        for (int i = 0; i < busyIcons.length; i++) {
            java.net.URL imageURL = TerrainFrame.class.getResource(String.format("images/busy-icon%d.png", i));
            if (imageURL != null) {
                busyIcons[i] = new ImageIcon(imageURL);
            }
        }
        busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
                statusAnimationLabel.setIcon(busyIcons[busyIconIndex]);
            }
        });
        java.net.URL imageURL = TerrainFrame.class.getResource("images/idle-icon.png");
        if (imageURL != null) {
            idleIcon = new ImageIcon(imageURL);
            statusAnimationLabel.setIcon(idleIcon);
        }
        statusAnimationLabel.setVisible(true);
        progressBar.setVisible(false);

        // connecting action tasks to status bar via TaskMonitor

        PropertyChangeListener listener = new java.beans.PropertyChangeListener() {

            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                String propertyName = evt.getPropertyName();
                String propertyValue = evt.getNewValue().toString();
                if ("state".equalsIgnoreCase(propertyName)) {
                    if (propertyValue.equalsIgnoreCase("STARTED")) {
                        if (!busyIconTimer.isRunning()) {
                            statusAnimationLabel.setIcon(busyIcons[0]);
                            busyIconIndex = 0;
                            busyIconTimer.start();
                            processing = true;
                        }
                        progressBar.setVisible(true);
                        //                       progressBar.setIndeterminate(true);
                    } else if ("done".equalsIgnoreCase(propertyValue)) {
                        busyIconTimer.stop();
                        statusAnimationLabel.setIcon(idleIcon);
                        progressBar.setVisible(false);
                        progressBar.setValue(0);
                        processing = false;
                    }
                } else if ("message".equals(propertyName)) {
                    String text = (String) (evt.getNewValue());
                    if (text == null || text.trim().length() == 0) {
                        eraseMessage();
                        return;
                    }
                    statusMessageLabel.setText(text);
                    messageTimer.restart();
                } else if ("progress".equals(propertyName)) {
                    int value = (Integer) (evt.getNewValue());
                    progressBar.setIndeterminate(false);
                    progressBar.setValue(value);
                } else if ("mouse".equals(propertyName)) {
                    XYZ point = (XYZ) evt.getNewValue();
                    if (point.equals(MosaicPanel.MOVED_OUT)) {
//                        statusMessageLabel.setText("");
                        gridrefdisplayed = false;
                        eraseMessage();
                        messageTimer.restart();
                        return;
                    }
                    if (processing) {
                        return;
                    }
                    gridrefdisplayed = true;
                    double east = e0 + wid * point.x();
                    double north = n0 + hgt * point.y();
                    double asl = point.z();
                    ENPair en = new ENPair(east, north);
                    try {
                        Projection project;
                        if (usedCentre instanceof UTM) {
                            int zone = ((UTM) usedCentre).getZone();
                            boolean northernHemisphere = ((UTM) usedCentre).getNorthernHemisphere();
                            project = (Projection) toolkit.makeCoordinateSystem(currentCoordType, en, zone, currentEllipsoid, currentDatum, northernHemisphere);
                        } else {
                            project = (Projection) toolkit.makeCoordinateSystem(currentCoordType, en, currentEllipsoid, currentDatum);
                        }
                        String heightString = "";
                        if (asl != SRTM2Reader.MISSING) {
                            heightString = String.format("    Z = %7.1fm", asl);
                        }
                        String text = project.toString() + heightString;
                        statusMessageLabel.setText(text);
                        messageTimer.restart();
                    } catch (Exception e) {
                        //Do nothing if an exception occurs in the toolkit
                    }

                }
            }
        };
        try {
            if (useASTER.equalsIgnoreCase("aster")) {
                reader = new ASTERReader(statusPanel);
                asterMenuItem.getModel().setSelected(true);
                legacyMenuItem.setEnabled(true);
            } else if (useASTER.equalsIgnoreCase("both")) {
                reader = new CompositeReader(statusPanel);
                bothMenuItem.getModel().setSelected(true);
                legacyMenuItem.setEnabled(true);
            } else if (useASTER.equalsIgnoreCase("srtm")) {
                reader = new SRTM2Reader(statusPanel); /////
                srtmMenuItem.getModel().setSelected(true);
                legacyMenuItem.setEnabled(false);
            }
            properties.set(TerrainProperties.ASTER, useASTER);
            legacyMenuItem.getModel().setSelected(useLegacyASTER.equalsIgnoreCase("true"));

        } catch (MissingDataFileException miss) {
            InfoMessage error = new InfoMessage("Initialisation error", miss.getMessage(), Severity.FATAL);
            error.display(this);
            System.exit(0);
        }
        statusPanel.addPropertyChangeListener(listener);
        pcs.addPropertyChangeListener(listener);
        pcs.addPropertyChangeListener(mosaic.getPropertyChangeListener());
        mosaic.addPropertyChangeListener(listener);
        jPanel1.add(mosaic, BorderLayout.CENTER);
        PropertyChangeListener[] readListen = reader.getPropertyChangeListeners();
        for (PropertyChangeListener hear : readListen) {
            pcs.addPropertyChangeListener(hear);
        }
        javax.swing.filechooser.FileNameExtensionFilter svxFilter = new javax.swing.filechooser.FileNameExtensionFilter("Survex raw survey data", "svx");
        javax.swing.filechooser.FileNameExtensionFilter csvFilter = new javax.swing.filechooser.FileNameExtensionFilter("Comma-separated variables", "csv");
        javax.swing.filechooser.FileNameExtensionFilter thFilter = new javax.swing.filechooser.FileNameExtensionFilter("Therion surface data", "th");
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.addChoosableFileFilter(thFilter);
        chooser.addChoosableFileFilter(csvFilter);
        chooser.addChoosableFileFilter(svxFilter);
        boolean auto = downloadSetting.equalsIgnoreCase("true");
        autoDownloadMenuItem.setState(auto);
        reader.setDownload(auto);
        String datasource = properties.get(TerrainProperties.FTP);
        if (datasource != null) {
            properties.set(TerrainProperties.FTP, datasource); //Make sure data host appears in properties file
        }
        String t = properties.get(TerrainProperties.EW);
        if (t != null) {
            wid = Double.parseDouble(t);
        }
        t = properties.get(TerrainProperties.NS);
        if (t != null) {
            hgt = Double.parseDouble(t);
        }
        t = properties.get(TerrainProperties.SPACING);
        if (t != null) {
            spacing = Double.parseDouble(t);
        }
        this.addWindowListener(new MainFrameListener());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        datasourceGroup = new javax.swing.ButtonGroup();
        statusPanel = new javax.swing.JPanel();
        statusAnimationLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        statusMessageLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        createMenuItem = new javax.swing.JMenuItem();
        latLongMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        optionsMenu = new javax.swing.JMenu();
        coordMenuItem = new javax.swing.JMenuItem();
        autoDownloadMenuItem = new javax.swing.JCheckBoxMenuItem();
        regionMenuItem = new javax.swing.JMenuItem();
        offsetMenuItem = new javax.swing.JMenuItem();
        therionMenuItem = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JSeparator();
        srtmMenuItem = new javax.swing.JRadioButtonMenuItem();
        asterMenuItem = new javax.swing.JRadioButtonMenuItem();
        bothMenuItem = new javax.swing.JRadioButtonMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        legacyMenuItem = new javax.swing.JRadioButtonMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, statusPanelLayout.createSequentialGroup()
                .addContainerGap(220, Short.MAX_VALUE)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusAnimationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusMessageLabel)
                .addContainerGap(390, Short.MAX_VALUE))
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(statusAnimationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
                    .addComponent(statusMessageLabel))
                .addContainerGap())
        );

        jPanel1.setLayout(new java.awt.BorderLayout());

        fileMenu.setText("File");
        fileMenu.setFont(fileMenu.getFont().deriveFont(fileMenu.getFont().getSize()-1f));

        createMenuItem.setFont(createMenuItem.getFont().deriveFont(createMenuItem.getFont().getSize()-1f));
        createMenuItem.setText("Create...     ");
        createMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(createMenuItem);

        latLongMenuItem.setFont(latLongMenuItem.getFont().deriveFont(latLongMenuItem.getFont().getSize()-1f));
        latLongMenuItem.setText("Lat/Long...");
        latLongMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                latLongMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(latLongMenuItem);

        saveAsMenuItem.setFont(saveAsMenuItem.getFont().deriveFont(saveAsMenuItem.getFont().getSize()-1f));
        saveAsMenuItem.setText("Save As ...     ");
        saveAsMenuItem.setEnabled(false);
        saveAsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveAsMenuItem);

        exitMenuItem.setFont(exitMenuItem.getFont().deriveFont(exitMenuItem.getFont().getSize()-1f));
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        optionsMenu.setText("Options");
        optionsMenu.setFont(optionsMenu.getFont().deriveFont(optionsMenu.getFont().getSize()-1f));

        coordMenuItem.setFont(coordMenuItem.getFont().deriveFont(coordMenuItem.getFont().getSize()-1f));
        coordMenuItem.setText("Coordinates...");
        coordMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coordMenuItemActionPerformed(evt);
            }
        });
        optionsMenu.add(coordMenuItem);

        autoDownloadMenuItem.setFont(autoDownloadMenuItem.getFont().deriveFont(autoDownloadMenuItem.getFont().getSize()-1f));
        autoDownloadMenuItem.setSelected(true);
        autoDownloadMenuItem.setText("Auto Download       ");
        autoDownloadMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autoDownloadMenuItemActionPerformed(evt);
            }
        });
        optionsMenu.add(autoDownloadMenuItem);

        regionMenuItem.setText("Region...");
        regionMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regionMenuItemActionPerformed(evt);
            }
        });
        optionsMenu.add(regionMenuItem);

        offsetMenuItem.setText("Offset...");
        offsetMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                offsetMenuItemActionPerformed(evt);
            }
        });
        optionsMenu.add(offsetMenuItem);

        therionMenuItem.setText("Therion...");
        therionMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                therionMenuItemActionPerformed(evt);
            }
        });
        optionsMenu.add(therionMenuItem);
        optionsMenu.add(jSeparator3);

        datasourceGroup.add(srtmMenuItem);
        srtmMenuItem.setSelected(true);
        srtmMenuItem.setText("SRTM Only");
        srtmMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srtmMenuItemActionPerformed(evt);
            }
        });
        optionsMenu.add(srtmMenuItem);

        datasourceGroup.add(asterMenuItem);
        asterMenuItem.setText("ASTER Only");
        asterMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asterMenuItemActionPerformed(evt);
            }
        });
        optionsMenu.add(asterMenuItem);

        datasourceGroup.add(bothMenuItem);
        bothMenuItem.setText("SRTM plus ASTER");
        bothMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bothMenuItemActionPerformed(evt);
            }
        });
        optionsMenu.add(bothMenuItem);
        optionsMenu.add(jSeparator2);

        legacyMenuItem.setText("Legacy ASTER Data");
        legacyMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                legacyMenuItemActionPerformed(evt);
            }
        });
        optionsMenu.add(legacyMenuItem);

        menuBar.add(optionsMenu);

        helpMenu.setText("Help");
        helpMenu.setFont(helpMenu.getFont().deriveFont(helpMenu.getFont().getSize()-1f));

        aboutMenuItem.setFont(aboutMenuItem.getFont().deriveFont(aboutMenuItem.getFont().getSize()-1f));
        aboutMenuItem.setText("About        ");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        doExit();
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void createMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createMenuItemActionPerformed
        reader.resetCounts();
        dlg.setGridRef(currentGridRef);
        dlg.setcoordName(currentCoordType);
        dlg.setExample("e.g. " + toolkit.getExample(currentCoordType));
        dlg.setNS(String.format("%13.2f", hgt));
        dlg.setEW(String.format("%13.2f", wid));
        dlg.setSpacing(String.format("%13.2f", spacing));
        dlg.setAlignment(alignment);
        dlg.setVisible(true);
        try {
            if (dlg.getReturnStatus() == LocationDialog.RET_OK) {
                currentGridRef = dlg.getGridRef();
                properties.set(TerrainProperties.GRIDREF, currentGridRef);
                wid = parseDouble(dlg.getEW());
                hgt = parseDouble(dlg.getNS());
                northSouthAlignment = dlg.getNSAlignment();
                eastWestAlignment = dlg.getEWAlignment();
                alignment = dlg.getAlignment();
                properties.set(TerrainProperties.ALIGNMENT, String.format(java.util.Locale.UK, "%d", alignment));
                spacing = parseDouble(dlg.getSpacing());
                properties.set(TerrainProperties.EW, String.format(java.util.Locale.UK, "%10.2f", wid));
                properties.set(TerrainProperties.SPACING, String.format(java.util.Locale.UK, "%10.2f", spacing));
                properties.set(TerrainProperties.NS, String.format(java.util.Locale.UK, "%10.2f", hgt));
                properties.set(TerrainProperties.REGION, region);

                if (properties.get(TerrainProperties.ASTER).equalsIgnoreCase("aster")) {
                    reader = new ASTERReader(statusPanel);
                    containsASTER = true;
                } else if (properties.get(TerrainProperties.ASTER).equalsIgnoreCase("both")) {
                    reader = new CompositeReader(statusPanel);
                } else if (properties.get(TerrainProperties.ASTER).equalsIgnoreCase("srtm")) {
                    reader = new SRTM2Reader(statusPanel); /////
                    containsASTER = false;
                }
                String leg = properties.get(TerrainProperties.LEGACYASTER);
                boolean v1 = leg.equalsIgnoreCase("true");
                reader.setLegacy(v1);
                CreateResults worker = new CreateResults();
                PropertyChangeListener[] listeners = statusPanel.getPropertyChangeListeners();
                for (PropertyChangeListener ear : listeners) {
                    worker.addPropertyChangeListener(ear);
                }
                worker.execute();
            }
        } catch (java.text.ParseException ex) {
            String[] text = {ex.getClass().getName(), ex.getMessage()};
            InfoMessage msg = new InfoMessage("Format error in numerical value", text, Severity.ERROR);
            msg.display(this);
            return;

        } catch (MissingDataFileException miss) {
            InfoMessage error = new InfoMessage("Initialisation error", miss.getMessage(), Severity.FATAL);
            error.display(this);
            System.exit(0);
        }
}//GEN-LAST:event_createMenuItemActionPerformed

    private void coordMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coordMenuItemActionPerformed
        currentCoordType = properties.get(TerrainProperties.COORD);
        currentDatum = toolkit.getDatum(properties.get(TerrainProperties.DATUM));
        currentEllipsoid = toolkit.getEllipsoid(properties.get(TerrainProperties.ELLIPSOID));
        coordset.setSelectedCoordType(currentCoordType);
        coordset.setEllipsoid(currentEllipsoid);
        coordset.setDatum(currentDatum);
        coordset.setVisible(true);
        if (coordset.getReturnStatus() == CoordinateDialog.RET_OK) {
            currentDatum = coordset.getDatum();
            currentEllipsoid = coordset.getEllipsoid();
            currentCoordType = coordset.getProjection();
            properties.set(TerrainProperties.ELLIPSOID, currentEllipsoid.toString());
            properties.set(TerrainProperties.DATUM, currentDatum.toString());
            properties.set(TerrainProperties.COORD, currentCoordType);
            properties.set(TerrainProperties.EXAMPLE, coordset.getExample());
            try {
                Projection latest = (Projection) toolkit.makeCoordinateSystem(currentCoordType, currentPosition(), currentEllipsoid, currentDatum);
                String tempGridRef = latest.toString();
                currentGridRef = tempGridRef;
                properties.set(TerrainProperties.GRIDREF, currentGridRef);
                return;
            } catch (Exception ex) {
                String[] text = {ex.getClass().getName(), ex.getMessage()};
                InfoMessage msg = new InfoMessage("Failed to set coordinate type", text, Severity.ERROR);
                msg.display(this);
                return;
            }
        }
    }//GEN-LAST:event_coordMenuItemActionPerformed

    private void saveAsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsMenuItemActionPerformed
        int result = chooser.showOpenDialog(mainFrame);
        if (result == javax.swing.JFileChooser.APPROVE_OPTION) {
            Saver worker = new Saver();
            PropertyChangeListener[] listeners = statusPanel.getPropertyChangeListeners();
            for (PropertyChangeListener ear : listeners) {
                worker.addPropertyChangeListener(ear);
            }

            worker.execute();
        }
    }//GEN-LAST:event_saveAsMenuItemActionPerformed

    private void autoDownloadMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autoDownloadMenuItemActionPerformed
        String newValue = "false";
        if (autoDownloadMenuItem.getState()) {
            newValue = "true";
        }
        properties.set(TerrainProperties.AUTO, newValue);
        setDownload(newValue);
        downloadSetting = newValue;
    }//GEN-LAST:event_autoDownloadMenuItemActionPerformed

    private void regionMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regionMenuItemActionPerformed
//        String region = properties.get(TerrainProperties.REGION);
        RegionSelect reg = new RegionSelect(this, true);
        reg.select(region);
        reg.setVisible(true);
        if (reg.getReturnStatus() == RegionSelect.RET_OK) {
            String newRegion = reg.getSelection();
            if (!region.equalsIgnoreCase(newRegion)) {
                properties.set(TerrainProperties.REGION, newRegion);
                region = newRegion;
            }
        }
    }//GEN-LAST:event_regionMenuItemActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        AboutDialog box = new AboutDialog(this, true);
        box.setVersion(versionID);
        java.util.Calendar cal = java.util.Calendar.getInstance(TimeZone.getTimeZone("GMT"), java.util.Locale.UK);
        cal.clear();
        cal.set(BUILDYEAR, BUILDMONTH - 1, BUILDDAY);
        String dateString = String.format("%1$Te-%1$tB-%1$TY", cal);
        box.setDate(dateString);
        box.setVisible(true);
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void offsetMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_offsetMenuItemActionPerformed
        OffsetDialog off = new OffsetDialog(this, true, eastOffset, northOffset, heightOffset);
        off.setVisible(true);
        if (off.getReturnStatus() == OffsetDialog.RET_OK) {
            eastOffset = off.getEastOffset();
            northOffset = off.getNorthOffset();
            heightOffset = off.getHeightOffset();
            properties.set(TerrainProperties.EASTOFFSET, String.format(java.util.Locale.UK, "%11.1f", eastOffset));
            properties.set(TerrainProperties.NORTHOFFSET, String.format(java.util.Locale.UK, "%11.1f", northOffset));
            properties.set(TerrainProperties.HEIGHTOFFSET, String.format(java.util.Locale.UK, "%11.1f", heightOffset));
        }
}//GEN-LAST:event_offsetMenuItemActionPerformed

    private void latLongMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_latLongMenuItemActionPerformed
        latlondialog.setPosition(currentPosition());
        latlondialog.setVisible(true);
        if (latlondialog.getReturnStatus() == LatLongDialog.RET_CANCEL) {
            return;
        }
        setCurrentPosition(latlondialog.getPosition());
        try {
            currentGridRef = "";
            Projection newPoint = (Projection) toolkit.makeCoordinateSystem(currentCoordType, currentPosition(), currentEllipsoid, currentDatum);
            currentGridRef = newPoint.toString();
        } catch (NoSuchMethodException ex) {
        } catch (GridFormatException ex) {
        } catch (IllegalAccessException ex) {
        } catch (IllegalArgumentException ex) {
        } catch (InvocationTargetException ex) {
        } catch (InstantiationException ex) {
        }
}//GEN-LAST:event_latLongMenuItemActionPerformed

    private void srtmMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srtmMenuItemActionPerformed
        if (srtmMenuItem.getModel().isSelected()) {
            properties.set(TerrainProperties.ASTER, "srtm");
            autoDownloadMenuItem.setEnabled(true);
            legacyMenuItem.setEnabled(false);
        }
    }//GEN-LAST:event_srtmMenuItemActionPerformed

    private void asterMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asterMenuItemActionPerformed
        if (asterMenuItem.getModel().isSelected()) {
            properties.set(TerrainProperties.ASTER, "aster");
            autoDownloadMenuItem.setEnabled(false);
            legacyMenuItem.setEnabled(true);
        }

    }//GEN-LAST:event_asterMenuItemActionPerformed

    private void bothMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bothMenuItemActionPerformed
        if (bothMenuItem.getModel().isSelected()) {
            properties.set(TerrainProperties.ASTER, "both");
            autoDownloadMenuItem.setEnabled(true);
            legacyMenuItem.setEnabled(true);
        }

    }//GEN-LAST:event_bothMenuItemActionPerformed

    private void therionMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_therionMenuItemActionPerformed
        TherionCSDialog tdlg = new TherionCSDialog(this, true);
        coordSystemString = properties.get(TerrainProperties.THERIONCS);
        tdlg.setCSName(coordSystemString);
        tdlg.setVisible(true);
        if (tdlg.getReturnStatus() == TherionCSDialog.RET_OK) {
            coordSystemString = tdlg.getCSName();
            properties.set(TerrainProperties.THERIONCS, coordSystemString);
        }
    }//GEN-LAST:event_therionMenuItemActionPerformed

    private void legacyMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_legacyMenuItemActionPerformed
        String res = "false";
        if (legacyMenuItem.getModel().isSelected()) {
            res = "true";
        }
        properties.set(TerrainProperties.LEGACYASTER, res);
    }//GEN-LAST:event_legacyMenuItemActionPerformed
    private Position currentPosition() {
        return currentLocation.getPosition();
    }
    /*
     * Parse a String for a double value using the current locale
     */

    private double parseDouble(String s) throws java.text.ParseException {
        java.text.NumberFormat nf = java.text.NumberFormat.getInstance();
        return nf.parse(s.trim()).doubleValue();
    }

    private void setCurrentPosition(Position pos) {
        currentLocation = new Spherical(pos, Ellipsoid.GRS80, Datum.WGS_1984);
        LatLong latlon = currentLocation.toLatLong();
        double lat = latlon.lat();
        double lon = latlon.lon();
        String latstr = String.format(java.util.Locale.UK, "%15.10f", lat);
        String lonstr = String.format(java.util.Locale.UK, "%15.10f", lon);
        properties.set(TerrainProperties.LAT, latstr);
        properties.set(TerrainProperties.LON, lonstr);
    }

    public String getAutodownload() {
        return downloadSetting;
    }

    public void setAutodownload(String flag) {
        this.pcs.firePropertyChange("autodownload", downloadSetting, flag);
        downloadSetting = flag;
    }

    private void eraseMessage() {
        if (!gridrefdisplayed) {
            statusMessageLabel.setText("");
            messageTimer.restart();


        }
    }

    private class CreateResults extends javax.swing.SwingWorker<InfoMessage, Object> {

        public InfoMessage doInBackground() {
            try {
                currentEllipsoid = toolkit.getEllipsoid(properties.get(TerrainProperties.ELLIPSOID));
                currentDatum = toolkit.getDatum(properties.get(TerrainProperties.DATUM));
                Projection startPoint = (Projection) toolkit.makeCoordinateSystem(currentCoordType, currentGridRef, currentEllipsoid, currentDatum);
                ENPair en1 = startPoint.toEN();
                if (eastWestAlignment == SwingConstants.LEFT) {
                    e0 = en1.east();
                } else if (eastWestAlignment == SwingConstants.RIGHT) {
                    e0 = en1.east() - wid;
                } else {
                    e0 = en1.east() - wid / 2.0;
                }
                if (northSouthAlignment == SwingConstants.BOTTOM) {
                    n0 = en1.north();
                } else if (northSouthAlignment == SwingConstants.TOP) {
                    n0 = en1.north() - hgt;
                } else {
                    n0 = en1.north() - hgt / 2.0;
                }
                ENPair en2 = new ENPair(e0 + wid / 2.0, n0 + hgt / 2.0);
                int zone = 0;
                boolean northernHemisphere = true;
                if (startPoint instanceof UTM) {
                    zone = ((UTM) startPoint).getZone();
                    northernHemisphere = ((UTM) startPoint).getNorthernHemisphere();
                    usedCentre = (Projection) toolkit.makeCoordinateSystem(currentCoordType, en2, zone, currentEllipsoid, currentDatum, northernHemisphere);
                } else {
                    usedCentre = (Projection) toolkit.makeCoordinateSystem(currentCoordType, en2, currentEllipsoid, currentDatum);
                }
                setCurrentPosition(startPoint.getPosition());
                int xpoints = (int) (wid / spacing);
                int ypoints = (int) (hgt / spacing);
                resultsTable = new float[ypoints][xpoints];
                long totpoints = xpoints * ypoints;
                long donepoints = 0;
                Projection point;
                for (int j = ypoints - 1; j >= 0; j--) {
                    for (int i = 0; i < xpoints; i++) {
                        double x = e0 + i * spacing;
                        double y = n0 + j * spacing;
                        ENPair en = new ENPair(x, y);
                        String type = startPoint.getName();
                        if (startPoint instanceof UTM) {
                            point = (Projection) toolkit.makeCoordinateSystem(type, en, zone, currentEllipsoid, currentDatum, northernHemisphere);
                        } else {
                            point = (Projection) toolkit.makeCoordinateSystem(type, en, currentEllipsoid, currentDatum);
                        }
                        Position q = point.getPosition();
                        Spherical t = new Spherical(q, Ellipsoid.GRS80, Datum.WGS_1984);
                        LatLong latlon = t.toLatLong();
                        resultsTable[j][i] = (float) reader.getHeight(latlon);
                        donepoints++;
                        int percentdone = (int) ((donepoints * 100) / totpoints);
                        setProgress(percentdone);
                    }
                }
                double hitrate = (double) reader.hits() / (double) reader.tries();
                String[] message = {String.format("Calculated %d points", reader.resultcount()),
                    String.format("Encountered %d missng data points", reader.missing()),
                    String.format("Cache hit-rate = %6.2f%%", hitrate * 100.0)
                };
                return new InfoMessage("Calculation complete", message, Severity.SUCCESS);
            } catch (Exception ex) {
                String[] msg = {"Unable to retrieve height data", ex.getClass().getName(), ex.getMessage()};
                return new InfoMessage("Failed", msg, Severity.FATAL);
            }
        }

        @Override
        protected void done() {
            try {
                InfoMessage message = get();
                unsaved = message.getSeverity() == Severity.SUCCESS;
                //Save info about the Coordinates, in case the user changes CoordinateSystem
                usedEllipsoid = currentEllipsoid;
                usedDatum = currentDatum;
                usedType = currentCoordType;

                saveAsMenuItem.setEnabled(unsaved);
                if (unsaved) {
                    mosaic.setDataTable(resultsTable);
                }
                mosaic.repaint();
                message.display(mainFrame);
            } catch (InterruptedException ex) {
            } catch (ExecutionException ex) {
            }
        }

        private void setMessage(String msg) {
            firePropertyChange("message", lastMessage, msg);
            lastMessage = msg;
        }
        private String lastMessage = "";
    }

    private class Saver extends javax.swing.SwingWorker<InfoMessage, Object> {

        public InfoMessage doInBackground() {
            try {
                extDefault = ((javax.swing.filechooser.FileNameExtensionFilter) (chooser.getFileFilter())).getExtensions()[0];
            } catch (ClassCastException e) {
                InfoMessage msg = new InfoMessage("Error", "Unsupported file type ", Severity.ERROR);
                return msg;
            }
            String ext = "";
            java.io.File outfile = chooser.getSelectedFile();

            try {
                String name = outfile.getCanonicalPath();
                int j = name.lastIndexOf(".");
                if (j < 0) {
                    name += "." + extDefault;
                    outfile = new java.io.File(name);
                    ext = extDefault;
                } else {
                    ext = name.substring(j + 1);
                }
                if (outfile.isFile()) {
                    String s = String.format("File %s already exists. Do you want to overwrite it?", name);
                    int response = javax.swing.JOptionPane.showConfirmDialog(mainFrame, s, "Confirm Overwrite", javax.swing.JOptionPane.YES_NO_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE);
                    if (response == javax.swing.JOptionPane.NO_OPTION) {
                        return new InfoMessage("User abort", "Operation cancelled by user", Severity.SUCCESS);
                    }
                }
                java.io.PrintWriter out = new java.io.PrintWriter(outfile);
                int ypoints = resultsTable.length;
                int xpoints = resultsTable[0].length;
                String saveMessage = String.format("Saving %s", outfile.getCanonicalPath());
                setMessage(saveMessage);
                java.util.Locale locale = java.util.Locale.UK;
                if (ext.equalsIgnoreCase("svx")) {
//Create a Survex data file
//Generate comments containing info about the projection etc.
                    out.printf(locale, "; Survex terrain data created by TerrainTool version %s from %s data%n", versionID, reader.datasetName());
                    out.printf(locale, "; %s%n", reader.copyright());
                    out.printf(locale, "; Used coordinate system %s with ellipsoid \"%s\" and datum \"%s\"%n", usedType, usedEllipsoid.toString(), usedDatum.toString());
                    Position pt = usedCentre.getPosition();
                    Spherical sp = new Spherical(pt, Ellipsoid.GRS80, Datum.WGS_1984);
                    out.printf(locale, "; Grid centred at %s%n", usedCentre);
                    LatLong latlon = sp.toLatLong();
                    double lat = latlon.lat();
                    double lon = latlon.lon();
                    out.printf(locale, "; Lat/Long of centre = %s  (%s %s) relative to WGS84/GRS80 datum%n", sp.toLatLongString(), LatLong.toDMS(lon, "EW"), LatLong.toDMS(lat, "NS"));
                    if (usedCentre instanceof TransverseMercator) {
                        double gc = Math.toDegrees(((TransverseMercator) usedCentre).gridConvergence());
                        out.printf(locale, "; Grid convergence at centre   = %7.3f degrees (%s)%n", gc, LatLong.toDMS(gc, "EW"));
                        out.printf(locale, "; Point scale factor at centre = %10.7f%n", ((TransverseMercator) usedCentre).pointScaleFactor());
                    } else if (usedCentre instanceof Orthomorphic) {
                        double gc = Math.toDegrees(((Orthomorphic) usedCentre).gridConvergence());
                        out.printf(locale, "; Grid convergence at centre   = %7.3f degrees (%s)%n", gc, LatLong.toDMS(gc, "EW"));
                    }
                    if (eastOffset != 0.0 || northOffset != 0 || heightOffset != 0) {
                        out.printf(locale, "; Output offset by adding (%10.2f,%10.2f,%8.2f) to calculated results", eastOffset, northOffset, heightOffset);
                    }
                    out.printf(";%n; TerrainTool (c) 2008 - 2019 Mike McCombe %n");
                    out.printf(";%n");
                    long toBeDone = 2 * ypoints + xpoints;
                    long doneSoFar = 0;
                    int q0 = name.lastIndexOf(java.io.File.separator);
                    String p0 = name.substring(q0 + 1);
                    int q1 = p0.indexOf(".");
                    String p1 = p0.substring(0, q1);
                    out.printf("*BEGIN %s%n", p1);
                    for (int k = 0; k < ypoints; k++) {
                        for (int i = 0; i < xpoints; i++) {
                            out.printf(locale, "*FIX N%dE%d %10.1f %10.1f %8.2f%n", k, i,
                                    eastOffset + e0 + i * spacing,
                                    northOffset + n0 + k * spacing,
                                    heightOffset + resultsTable[k][i]);
                        }
                        doneSoFar++;
                        reportProgress(toBeDone, doneSoFar);
                    }
                    out.printf("*DATA nosurvey station%n");
                    out.printf("*FLAGS surface%n");
                    boolean broken = true;
                    for (int k = 0; k < ypoints; k++) {
                        for (int i = 0; i < xpoints; i++) {
                            if (resultsTable[k][i] != SRTM2Reader.MISSING) {
                                out.printf(locale, "N%dE%d %n", k, i);
                                broken = false;
                            } else if (!broken) {
                                out.printf("%n");
                                broken = true;
                            }
                        }
                        out.printf("%n");
                        doneSoFar++;
                        reportProgress(toBeDone, doneSoFar);
                        broken = true;
                    }
                    for (int i = 0; i < xpoints; i++) {
                        for (int k = 0; k < ypoints; k++) {
                            if (resultsTable[k][i] != SRTM2Reader.MISSING) {
                                out.printf(locale, "N%dE%d %n", k, i);
                                broken = false;
                            } else if (!broken) {
                                out.printf("%n");
                                broken = true;
                            }
                        }
                        out.printf("%n");
                        doneSoFar++;
                        reportProgress(toBeDone, doneSoFar);
                    }

                    out.printf("*END %s%n", p1);
                    out.close();

                } else if (ext.equalsIgnoreCase("csv")) {
                    out.printf(locale, "%6d,", ypoints);
                    for (int i = 0; i < xpoints - 1; i++) {
                        out.printf(locale, "%10.2f,", e0 + i * spacing);
                    }
                    out.printf(locale, "%10.2f%n", eastOffset + e0 + (xpoints - 1) * spacing);
                    long toBeDone = ypoints;
                    long doneSoFar = 0;
                    for (int k = 0; k < ypoints; k++) {
                        out.printf(locale, "%10.2f,", northOffset + n0 + k * spacing);
                        for (int i = 0; i < xpoints - 1; i++) {
                            out.printf(locale, "%10.2f,", heightOffset + resultsTable[k][i]);
                        }
                        out.printf(locale, "%10.2f%n", resultsTable[k][xpoints - 1]);
                        doneSoFar++;
                        reportProgress(toBeDone, doneSoFar);
                    }
                    out.close();
                } else if (ext.equalsIgnoreCase("th")) {

//Generate comments containing info about the projection etc.
                    out.printf(locale, "# Therion terrain data created by TerrainTool version %s from %s data%n", versionID, reader.datasetName());
                    out.printf(locale, "# %s%n", reader.copyright());
                    out.printf(locale, "# Used coordinate system %s with ellipsoid \"%s\" and datum \"%s\"%n", usedType, usedEllipsoid.toString(), usedDatum.toString());
                    Position pt = usedCentre.getPosition();
                    Spherical sp = new Spherical(pt, Ellipsoid.GRS80, Datum.WGS_1984);
                    out.printf(locale, "# Grid centred at %s%n", usedCentre);
                    LatLong latlon = sp.toLatLong();
                    double lat = latlon.lat();
                    double lon = latlon.lon();
                    out.printf(locale, "# Lat/Long of centre = %s  (%s %s) relative to WGS84/GRS80 datum%n", sp.toLatLongString(), LatLong.toDMS(lon, "EW"), LatLong.toDMS(lat, "NS"));
                    if (usedCentre instanceof TransverseMercator) {
                        double gc = Math.toDegrees(((TransverseMercator) usedCentre).gridConvergence());
                        out.printf(locale, "# Grid convergence at centre   = %7.3f degrees (%s)%n", gc, LatLong.toDMS(gc, "EW"));
                        out.printf(locale, "# Point scale factor at centre = %10.7f%n", ((TransverseMercator) usedCentre).pointScaleFactor());
                    } else if (usedCentre instanceof Orthomorphic) {
                        double gc = Math.toDegrees(((Orthomorphic) usedCentre).gridConvergence());
                        out.printf(locale, "# Grid convergence at centre   = %7.3f degrees (%s)%n", gc, LatLong.toDMS(gc, "EW"));
                    }
                    if (eastOffset != 0.0 || northOffset != 0 || heightOffset != 0) {
                        out.printf(locale, "# Output offset by adding (%10.2f,%10.2f,%8.2f) to calculated results", eastOffset, northOffset, heightOffset);
                    }
                    out.printf("#%n# TerrainTool (c) 2008 - 2019 Mike McCombe %n");
                    out.printf("#%n");


                    out.println("surface");
                    out.printf(locale, "cs %s%n", coordSystemString);
                    out.println("grid-units meter");
                    out.printf(locale, "grid %10.2f %10.2f %.2f %.2f %d %d%n", e0 + eastOffset, n0 + northOffset, spacing, spacing, xpoints, ypoints);
                    long toBeDone = ypoints;
                    long doneSoFar = 0;
                    for (int k = ypoints - 1; k >= 0; k--) {
                        for (int i = 0; i < xpoints - 1; i++) {
                            out.printf(locale, "%10.2f ", heightOffset + resultsTable[k][i]);
                        }
                        out.printf(locale, "%10.2f%n", resultsTable[k][xpoints - 1]);
                        doneSoFar++;
                        reportProgress(toBeDone, doneSoFar);
                    }
                    out.println("endsurface");
                    out.close();
                } else {
                    InfoMessage msg = new InfoMessage("Error", "Unsupported file type \"" + ext + "\"", Severity.ERROR);
                    return msg;
                }
                setMessage("Done");
                return new InfoMessage("Operation complete", "File saved", Severity.SUCCESS);
            } catch (IOException e) {
                InfoMessage msg = new InfoMessage("I/O Exception", e.toString(), Severity.ERROR);
                return msg;
            }
        }

        private void setMessage(String msg) {
            firePropertyChange("message", lastMessage, msg);
            lastMessage = msg;
        }

        private void reportProgress(long toDo, long doneSoFar) {
            int percent = (int) (doneSoFar * 100 / toDo);
            setProgress(percent);
        }

        @Override
        protected void done() {
            progressBar.setVisible(false);
            progressBar.setValue(0);
            try {
                InfoMessage message = get();
                if (message.getSeverity() != Severity.SUCCESS) {
                    message.display(mainFrame);
                }
                unsaved = false;
            } catch (InterruptedException ex) {
///                Logger.getLogger(SRTMView.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
///                Logger.getLogger(SRTMView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        private String extDefault;
    }

    private class MainFrameListener extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            doExit();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.setProperty("https.protocols", "SSLv3,TLSv1,TLSv1.1,TLSv1.2");
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    TerrainFrame frame = new TerrainFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    if (!TerrainFrame.properties.isValid()) {
                        System.out.println("Fatal - failed to create properties file");
                    } else {
                        System.out.println("Unexpected fatal exception during initialisation");
                        System.out.println(e);
                        System.exit(0);
                    }
                }
            }
        });
    }

    public void doExit() {
        try {
            if (unsaved) {
                String[] message = {"The terrain data has not been saved", "Do you still wish to exit?"};
                int retValue = javax.swing.JOptionPane.showConfirmDialog(mainFrame, message, "Warning", javax.swing.JOptionPane.OK_CANCEL_OPTION, javax.swing.JOptionPane.WARNING_MESSAGE);
                okToExit = (retValue == javax.swing.JOptionPane.OK_OPTION);
                if (!okToExit) {
                    return;
                }
            }
            properties.save();
        } catch (IOException ex) {
            //if the properties file can't be updated, too bad!
        }
        System.exit(0);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JRadioButtonMenuItem asterMenuItem;
    private javax.swing.JCheckBoxMenuItem autoDownloadMenuItem;
    private javax.swing.JRadioButtonMenuItem bothMenuItem;
    private javax.swing.JMenuItem coordMenuItem;
    private javax.swing.JMenuItem createMenuItem;
    private javax.swing.ButtonGroup datasourceGroup;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JMenuItem latLongMenuItem;
    private javax.swing.JRadioButtonMenuItem legacyMenuItem;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem offsetMenuItem;
    private javax.swing.JMenu optionsMenu;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JMenuItem regionMenuItem;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JRadioButtonMenuItem srtmMenuItem;
    private javax.swing.JLabel statusAnimationLabel;
    private javax.swing.JLabel statusMessageLabel;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JMenuItem therionMenuItem;
    // End of variables declaration//GEN-END:variables
    /*
     * Pathnames object to point to properties file and data cache
     * 
     */
    protected static Pathnames paths = new DefaultPathnames(); //Change this class to achieve os-specific behaviour
    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private Icon idleIcon = null;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;
    private JDialog aboutBox;
///    private SRTM2Reader reader = null; /////
    private DEMReader reader = null; /////
    private float[][] resultsTable = null;
    private double e0, n0;
    private double wid = Double.parseDouble(properties.get(TerrainProperties.EW));
    private double hgt = Double.parseDouble(properties.get(TerrainProperties.NS));
    private double spacing = Double.parseDouble(properties.get(TerrainProperties.SPACING));
    private Projection usedCentre;
    private String usedType = "";
    private Ellipsoid usedEllipsoid;
    private Datum usedDatum;
    private javax.swing.JFileChooser chooser = new javax.swing.JFileChooser();
    private MappingToolkit toolkit = new MappingToolkit();
    private CoordinateDialog coordset = new CoordinateDialog(this, true, toolkit);
    private String lastMessage = "";
    private boolean unsaved = false;
    private boolean okToExit = true;
    private JFrame mainFrame = this;
    private static final DefaultProperties defaults = new DefaultProperties();
    public static PropertySet properties = new PropertySet(paths.propertiesPath(), defaults);
    private String downloadSetting = properties.get(TerrainProperties.AUTO);
    private String region = properties.get(TerrainProperties.REGION);
    private String currentGridRef = properties.get(TerrainProperties.GRIDREF);
    private String useLegacyASTER = properties.get(TerrainProperties.LEGACYASTER);
    private MosaicPanel mosaic = new MosaicPanel();
    private double currentLatitude = Double.parseDouble(properties.get(TerrainProperties.LAT));
    private double currentLongitude = Double.parseDouble(properties.get(TerrainProperties.LON));
    private Spherical currentLocation = new Spherical(new LatLong(currentLatitude, currentLongitude), Ellipsoid.GRS80, Datum.WGS_1984);
//    private Position currentPosition = currentLocation.getPosition();
    private Ellipsoid currentEllipsoid = toolkit.getEllipsoid(properties.get(TerrainProperties.ELLIPSOID));
    private Datum currentDatum = toolkit.getDatum(properties.get(TerrainProperties.DATUM));
    private String currentCoordType = properties.get(TerrainProperties.COORD);
    private LocationDialog dlg = new LocationDialog(this, true, toolkit, properties);
    private double eastOffset = Double.parseDouble(properties.get(TerrainProperties.EASTOFFSET));
    private double northOffset = Double.parseDouble(properties.get(TerrainProperties.NORTHOFFSET));
    private double heightOffset = Double.parseDouble(properties.get(TerrainProperties.HEIGHTOFFSET));
    PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    private boolean gridrefdisplayed = false;
    private boolean processing = false;
    private int northSouthAlignment = SwingConstants.BOTTOM;
    private int eastWestAlignment = SwingConstants.LEFT;
    private int alignment = Integer.parseInt(properties.get(TerrainProperties.ALIGNMENT));
    private LatLongDialog latlondialog = new LatLongDialog(this, true, toolkit, currentLocation);
    private boolean allowDataChoice = true;
    private String useASTER = properties.get(TerrainProperties.ASTER);
    private String coordSystemString = properties.get(TerrainProperties.THERIONCS);
    private boolean containsASTER = false;
    /*
     * Version information
     */
    private static final String versionID = "1.14"; // Version 1.14 12th January 2019
    private static final int BUILDYEAR = 2019;
    private static final int BUILDMONTH = 1;
    private static final int BUILDDAY = 12;
    /**
     * Holds value of property download.
     */
    private String download;

    /**
     * Adds a PropertyChangeListener to the listener list.
     *
     * @param l The listener to add.
     */
    public void addPropertyChangeListener(java.beans.PropertyChangeListener l) {
        pcs.addPropertyChangeListener(l);
    }

    /**
     * Removes a PropertyChangeListener from the listener list.
     *
     * @param l The listener to remove.
     */
    public void removePropertyChangeListener(java.beans.PropertyChangeListener l) {
        pcs.removePropertyChangeListener(l);
    }

    /**
     * Getter for property download.
     *
     * @return Value of property download.
     */
    public String getDownload() {
        return this.download;
    }

    /**
     * Setter for property download.
     *
     * @param download New value of property download.
     */
    public void setDownload(String download) {
        String oldDownload = this.download;
        this.download = download;
        pcs.firePropertyChange("download", oldDownload, download);
    }
}
