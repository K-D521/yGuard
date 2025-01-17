/*
 * YGuard -- an obfuscation library for Java(TM) classfiles.
 *
 * Original Copyright (c) 1999 Mark Welsh (markw@retrologic.com)
 * Modifications Copyright (c) 2002 yWorks GmbH (yguard@yworks.com)
 *
 */
package com.yworks.yguard.obf;

/**
 * Tree item representing a method.
 *
 * @author Mark Welsh
 */
public class Md extends MdFd
{
    // Constants -------------------------------------------------------------


    // Fields ----------------------------------------------------------------


    // Class Methods ---------------------------------------------------------


    // Instance Methods ------------------------------------------------------

    /**
     * Ctor.
     *
     * @param parent            the parent
     * @param isSynthetic       the is synthetic
     * @param name              the name
     * @param descriptor        the descriptor
     * @param access            the access
     * @param obfuscationConfig the obfuscation config
     */
    public Md(TreeItem parent, boolean isSynthetic, String name, String descriptor,
              int access, ObfuscationConfig obfuscationConfig)
    {
        super(parent, isSynthetic, name, descriptor, access, obfuscationConfig);
    }

    /** Return the display name of the descriptor types. */
    protected String getDescriptorName()
    {
        String[] types = parseTypes();
        StringBuffer sb = new StringBuffer();
        sb.append("(");
        if (types.length > 0)
        {
            for (int i = 0; i < types.length - 1; i++)
            {
                sb.append(types[i]);
                if (i < types.length - 2)
                {
                    sb.append(", ");
                }
            }
        }
        sb.append(");");
        return sb.toString();
    }

    /**
     * Are this method's name/descriptor a match to the wildcard patterns?
     *
     * @param namePattern the name pattern
     * @param descPattern the desc pattern
     * @return the boolean
     */
    public boolean isWildcardMatch(String namePattern, String descPattern) {
        return 
            isMatch(namePattern, getFullInName()) &&
            isMatch(descPattern, getDescriptor());
    }

    /**
     * Are this method's name/descriptor a non-recursive match
     * to the wildcard patterns?
     *
     * @param namePattern the name pattern
     * @param descPattern the desc pattern
     * @return the boolean
     */
    public boolean isNRWildcardMatch(String namePattern, String descPattern) {
        return
                isNonRecursiveWildcardMatch(namePattern, getFullInName()) &&
            isMatch(descPattern, getDescriptor());
    }
}

