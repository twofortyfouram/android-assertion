/*
 * android-assertion-lib https://github.com/twofortyfouram/android-assertion
 * Copyright 2014 two forty four a.m. LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.twofortyfouram.assertion;

import com.twofortyfouram.test.assertion.MoarAsserts;

import junit.framework.TestCase;

import android.location.Address;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.test.suitebuilder.annotation.SmallTest;

import java.util.Locale;

/**
 * Tests {@link com.twofortyfouram.assertion.BundleAssertions}.
 */
public final class BundleAssertionsTest extends TestCase {

    @SmallTest
    public static void testNonInstantiable() {
        MoarAsserts.assertNoninstantiable(BundleAssertions.class);
    }

    @SmallTest
    public static void testHasKey_missing() {
        final Bundle bundle = new Bundle();

        try {
            BundleAssertions.assertHasKey(bundle, "test_key"); //$NON-NLS-1$
            fail();
        } catch (final AssertionError e) {
            // Expected exception
        }
    }

    @SmallTest
    public static void testHasKey_valid_int() {
        final Bundle bundle = new Bundle();
        bundle.putInt("test_key", 1);

        BundleAssertions.assertHasKey(bundle, "test_key"); //$NON-NLS-1$
    }

    @SmallTest
    public static void testHasKey_valid_null() {
        final Bundle bundle = new Bundle();
        bundle.putString(null, null);

        BundleAssertions.assertHasKey(bundle, null);
    }

    @SmallTest
    public static void testHasBoolean_missing() {
        final Bundle bundle = new Bundle();

        try {
            BundleAssertions.assertHasBoolean(bundle, "test_key"); //$NON-NLS-1$
            fail();
        } catch (final AssertionError e) {
            // Expected exception
        }
    }

    @SmallTest
    public static void testHasBoolean_wrong_type() {
        final Bundle bundle = new Bundle();
        bundle.putString("test_key", null); //$NON-NLS-1$

        try {
            BundleAssertions.assertHasBoolean(bundle, "test_key"); //$NON-NLS-1$
            fail();
        } catch (final AssertionError e) {
            // Expected exception
        }

        bundle.putString("test_key", "foo"); //$NON-NLS-1$ //$NON-NLS-2$

        try {
            BundleAssertions.assertHasBoolean(bundle, "test_key"); //$NON-NLS-1$
            fail();
        } catch (final AssertionError e) {
            // Expected exception
        }
    }

    @SmallTest
    public static void testHasBoolean_valid() {
        final Bundle bundle = new Bundle();
        bundle.putBoolean("test_key", true); //$NON-NLS-1$

        BundleAssertions.assertHasBoolean(bundle, "test_key"); //$NON-NLS-1$

        bundle.putBoolean("test_key", false); //$NON-NLS-1$
        BundleAssertions.assertHasBoolean(bundle, "test_key"); //$NON-NLS-1$
    }

    @SmallTest
    public static void testHasByteArray_missing() {
        final Bundle bundle = new Bundle();

        try {
            BundleAssertions.assertHasByteArray(bundle, "test_key"); //$NON-NLS-1$
            fail();
        } catch (final AssertionError e) {
            // Expected exception
        }
    }

    @SmallTest
    public static void testHasByteArray_wrong_type() {
        final Bundle bundle = new Bundle();
        bundle.putString("test_key", null); //$NON-NLS-1$

        try {
            BundleAssertions.assertHasByteArray(bundle, "test_key"); //$NON-NLS-1$
            fail();
        } catch (final AssertionError e) {
            // Expected exception
        }

        bundle.putString("test_key", "foo"); //$NON-NLS-1$ //$NON-NLS-2$

        try {
            BundleAssertions.assertHasByteArray(bundle, "test_key"); //$NON-NLS-1$
            fail();
        } catch (final AssertionError e) {
            // Expected exception
        }
    }

    @SmallTest
    public static void testHasByteArray_valid() {
        final Bundle bundle = new Bundle();
        bundle.putByteArray("test_key", new byte[0]); //$NON-NLS-1$

        BundleAssertions.assertHasByteArray(bundle, "test_key"); //$NON-NLS-1$
    }

    @SmallTest
    public static void testHasInt_missing() {
        final Bundle bundle = new Bundle();

        try {
            BundleAssertions.assertHasInt(bundle, "test_key"); //$NON-NLS-1$
            fail();
        } catch (final AssertionError e) {
            // Expected exception
        }
    }

    @SmallTest
    public static void testHasInt_missing_range() {
        final Bundle bundle = new Bundle();

        try {
            BundleAssertions.assertHasInt(bundle, "test_key", 0, 1); //$NON-NLS-1$
            fail();
        } catch (final AssertionError e) {
            // Expected exception
        }
    }

    @SmallTest
    public static void testHasInt_wrong_type() {
        final Bundle bundle = new Bundle();
        bundle.putString("test_key", null); //$NON-NLS-1$

        try {
            BundleAssertions.assertHasInt(bundle, "test_key"); //$NON-NLS-1$
            fail();
        } catch (final AssertionError e) {
            // Expected exception
        }

        try {
            BundleAssertions.assertHasInt(bundle, "test_key", 0, 1); //$NON-NLS-1$
            fail();
        } catch (final AssertionError e) {
            // Expected exception
        }

        bundle.putString("test_key", "foo"); //$NON-NLS-1$ //$NON-NLS-2$

        try {
            BundleAssertions.assertHasInt(bundle, "test_key"); //$NON-NLS-1$
            fail();
        } catch (final AssertionError e) {
            // Expected exception
        }

        try {
            BundleAssertions.assertHasInt(bundle, "test_key", 0, 1); //$NON-NLS-1$
            fail();
        } catch (final AssertionError e) {
            // Expected exception
        }
    }

    @SmallTest
    public static void testHasInt_valid() {
        final Bundle bundle = new Bundle();
        bundle.putInt("test_key", 52); //$NON-NLS-1$

        BundleAssertions.assertHasInt(bundle, "test_key"); //$NON-NLS-1$
    }

    @SmallTest
    public static void testHasInt_range_valid() {
        final Bundle bundle = new Bundle();
        bundle.putInt("test_key", 52); //$NON-NLS-1$

        BundleAssertions.assertHasInt(bundle, "test_key", 52, 52); //$NON-NLS-1$
        BundleAssertions.assertHasInt(bundle, "test_key", 52, 100); //$NON-NLS-1$
        BundleAssertions.assertHasInt(bundle, "test_key", -100, 52); //$NON-NLS-1$
    }

    @SmallTest
    public static void testHasInt_range_above() {
        final Bundle bundle = new Bundle();
        bundle.putInt("test_key", 17); //$NON-NLS-1$

        try {
            BundleAssertions.assertHasInt(bundle, "test_key", 0, 15); //$NON-NLS-1$
            fail();
        } catch (final AssertionError e) {
            // Expected exception
        }
    }

    @SmallTest
    public static void testHasInt_range_below() {
        final Bundle bundle = new Bundle();
        bundle.putInt("test_key", 17); //$NON-NLS-1$

        try {
            BundleAssertions.assertHasInt(bundle, "test_key", 27, 502); //$NON-NLS-1$
            fail();
        } catch (final AssertionError e) {
            // Expected exception
        }
    }

    @SmallTest
    public static void testHasInt_range_bad() {
        try {
            BundleAssertions.assertHasInt(new Bundle(), "test_key", 2, 1); //$NON-NLS-1$
            fail();
        } catch (final IllegalArgumentException e) {
            // Expected exception
        }
    }

    @SmallTest
    public static void testHasLong_missing() {
        final Bundle bundle = new Bundle();

        try {
            BundleAssertions.assertHasLong(bundle, "test_key"); //$NON-NLS-1$
            fail();
        } catch (final AssertionError e) {
            // Expected exception
        }

        try {
            BundleAssertions.assertHasLong(bundle, "test_key", 0, 1); //$NON-NLS-1$
            fail();
        } catch (final AssertionError e) {
            // Expected exception
        }
    }

    @SmallTest
    public static void testHasLong_missing_range() {
        final Bundle bundle = new Bundle();

        try {
            BundleAssertions.assertHasLong(bundle, "test_key", 0, 1); //$NON-NLS-1$
            fail();
        } catch (final AssertionError e) {
            // Expected exception
        }
    }

    @SmallTest
    public static void testHasLong_wrong_type() {
        final Bundle bundle = new Bundle();
        bundle.putString("test_key", null); //$NON-NLS-1$

        try {
            BundleAssertions.assertHasLong(bundle, "test_key"); //$NON-NLS-1$
            fail();
        } catch (final AssertionError e) {
            // Expected exception
        }

        try {
            BundleAssertions.assertHasLong(bundle, "test_key", 0, 1); //$NON-NLS-1$
            fail();
        } catch (final AssertionError e) {
            // Expected exception
        }

        bundle.putString("test_key", "foo"); //$NON-NLS-1$ //$NON-NLS-2$

        try {
            BundleAssertions.assertHasLong(bundle, "test_key"); //$NON-NLS-1$
            fail();
        } catch (final AssertionError e) {
            // Expected exception
        }

        try {
            BundleAssertions.assertHasLong(bundle, "test_key", 0, 1); //$NON-NLS-1$
            fail();
        } catch (final AssertionError e) {
            // Expected exception
        }
    }

    @SmallTest
    public static void testHasLong_valid() {
        final Bundle bundle = new Bundle();
        bundle.putLong("test_key", Long.MAX_VALUE); //$NON-NLS-1$

        BundleAssertions.assertHasLong(bundle, "test_key"); //$NON-NLS-1$
    }

    @SmallTest
    public static void testHasLong_range_valid() {
        final Bundle bundle = new Bundle();
        bundle.putLong("test_key", Long.MAX_VALUE - 1); //$NON-NLS-1$

        BundleAssertions.assertHasLong(bundle, "test_key", Long.MAX_VALUE-1, Long.MAX_VALUE); //$NON-NLS-1$
        BundleAssertions.assertHasLong(bundle, "test_key", 0, Long.MAX_VALUE); //$NON-NLS-1$
        BundleAssertions.assertHasLong(bundle, "test_key", 0, Long.MAX_VALUE-1); //$NON-NLS-1$
    }

    @SmallTest
    public static void testHasLong_range_above() {
        final Bundle bundle = new Bundle();
        bundle.putLong("test_key", Long.MAX_VALUE); //$NON-NLS-1$

        try {
            BundleAssertions.assertHasLong(bundle, "test_key", 0, Long.MAX_VALUE-1); //$NON-NLS-1$
            fail();
        } catch (final AssertionError e) {
            // Expected exception
        }
    }

    @SmallTest
    public static void testHasLong_range_below() {
        final Bundle bundle = new Bundle();
        bundle.putLong("test_key", Long.MIN_VALUE); //$NON-NLS-1$

        try {
            BundleAssertions.assertHasLong(bundle, "test_key", 0, Long.MAX_VALUE); //$NON-NLS-1$
            fail();
        } catch (final AssertionError e) {
            // Expected exception
        }
    }

    @SmallTest
    public static void testHasLong_range_bad() {
        try {
            BundleAssertions.assertHasLong(new Bundle(), "test_key", Long.MAX_VALUE, Long.MIN_VALUE); //$NON-NLS-1$
            fail();
        } catch (final IllegalArgumentException e) {
            // Expected exception
        }
    }

    @SmallTest
    public static void testHasParcelable_missing() {
        final Bundle bundle = new Bundle();


        try {
            BundleAssertions.assertHasParcelable(bundle, "test_key", Location.class); //$NON-NLS-1$
            fail();
        } catch (final AssertionError e) {
            // Expected exception
        }
    }

    @SmallTest
    public static void testHasParcelable_null() {
        final Bundle bundle = new Bundle();
        bundle.putParcelable("test_key", null); //$NON-NLS-1$

        try {
            BundleAssertions.assertHasParcelable(bundle, "test_key", Location.class); //$NON-NLS-1$
            fail();
        } catch (final AssertionError e) {
            // Expected exception
        }
    }

    @SmallTest
    public static void testHasParcelable_not_parcelable() {
        final Bundle bundle = new Bundle();
        bundle.putString("test_key", "test_value"); //$NON-NLS-1$

        try {
            BundleAssertions.assertHasParcelable(bundle, "test_key", Location.class); //$NON-NLS-1$
            fail();
        } catch (final AssertionError e) {
            // Expected exception
        }
    }

    @SmallTest
    public static void testHasParcelable_wrong_type() {
        final Bundle bundle = new Bundle();
        bundle.putParcelable("test_key", new Address(Locale.US)); //$NON-NLS-1$

        try {
            BundleAssertions.assertHasParcelable(bundle, "test_key", Location.class); //$NON-NLS-1$
            fail();
        } catch (final AssertionError e) {
            // Expected exception
        }
    }

    @SmallTest
    public static void testHasString_missing() {
        final Bundle bundle = new Bundle();

        try {
            BundleAssertions.assertHasString(bundle, "test_key"); //$NON-NLS-1$
            fail();
        } catch (final AssertionError e) {
            // Expected exception
        }
    }

    @SmallTest
    public static void testHasString_wrong_type() {
        final Bundle bundle = new Bundle();
        bundle.putInt("test_key", 5); //$NON-NLS-1$

        try {
            BundleAssertions.assertHasString(bundle, "test_key"); //$NON-NLS-1$
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1) {
                fail();
            }
        } catch (final AssertionError e) {
            // Expected exception
        }
    }

    @SmallTest
    public static void testHasString_valid() {
        final Bundle bundle = new Bundle();
        bundle.putString("test_key", "test_value"); //$NON-NLS-1$ //$NON-NLS-2$

        BundleAssertions.assertHasString(bundle, "test_key"); //$NON-NLS-1$

        bundle.putString("test_key", null); //$NON-NLS-1$
        BundleAssertions.assertHasString(bundle, "test_key"); //$NON-NLS-1$
    }

    @SmallTest
    public static void testHasString_allowed_values_valid() {
        final Bundle bundle = new Bundle();
        bundle.putString("test_key", "test_value"); //$NON-NLS-1$ //$NON-NLS-2$

        BundleAssertions.assertHasString(bundle, "test_key",
                new String[]{"test_value"}); //$NON-NLS-1$ //$NON-NLS-2$
        BundleAssertions.assertHasString(bundle, "test_key",
                new String[]{"bork", "test_value"}); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
    }

    @SmallTest
    public static void testHasString_allowed_values_case_sensitive() {
        final Bundle bundle = new Bundle();
        bundle.putString("test_key", "test_value"); //$NON-NLS-1$ //$NON-NLS-2$
        try {
            BundleAssertions.assertHasString(bundle, "test_key",
                    new String[]{"TEST_VALUE"}); //$NON-NLS-1$ //$NON-NLS-2$
            fail("Matching should be case sensitive"); //$NON-NLS-1$
        } catch (final AssertionError e) {
            // Expected exception
        }
    }

    @SmallTest
    public static void testHasString_allowed_values_missing() {
        final Bundle bundle = new Bundle();
        bundle.putString("test_key", "test_value"); //$NON-NLS-1$ //$NON-NLS-2$

        try {
            BundleAssertions.assertHasString(bundle, "test_key",
                    new String[]{"bork"}); //$NON-NLS-1$ //$NON-NLS-2$
            fail();
        } catch (final AssertionError e) {
            // Expected exception
        }
    }

    @SmallTest
    public static void testHasString_allowed_values_null() {
        final Bundle bundle = new Bundle();
        bundle.putString("test_key", null); //$NON-NLS-1$

        BundleAssertions.assertHasString(bundle, "test_key", new String[]{null}); //$NON-NLS-1$
    }

    @SmallTest
    public static void testHasString_allowed_values_empty_string() {
        final Bundle bundle = new Bundle();
        bundle.putString("test_key", ""); //$NON-NLS-1$ //$NON-NLS-2$

        BundleAssertions
                .assertHasString(bundle, "test_key", new String[]{""}); //$NON-NLS-1$ //$NON-NLS-2$
    }

    @SmallTest
    public static void testHasString_allowed_values_empty_array() {
        final Bundle bundle = new Bundle();
        bundle.putString("test_key", "test_value"); //$NON-NLS-1$ //$NON-NLS-2$

        try {
            BundleAssertions.assertHasString(bundle, "test_key", new String[0]); //$NON-NLS-1$
            fail();
        } catch (final AssertionError e) {
            // Expected exception
        }
    }

    @SmallTest
    public static void testHasString_allowed_values_null_array() {
        final Bundle bundle = new Bundle();
        bundle.putString("test_key", "test_value"); //$NON-NLS-1$ //$NON-NLS-2$

        BundleAssertions.assertHasString(bundle, "test_key", (String[]) null); //$NON-NLS-1$
    }

    @SmallTest
    public static void testHasString_null_valid() {
        final Bundle bundle = new Bundle();
        bundle.putString("test_key", null); //$NON-NLS-1$

        BundleAssertions.assertHasString(bundle, "test_key", true, true); //$NON-NLS-1$
        BundleAssertions.assertHasString(bundle, "test_key", true, false); //$NON-NLS-1$
    }

    @SmallTest
    public static void testHasString_null_invalid() {
        final Bundle bundle = new Bundle();
        bundle.putString("test_key", null); //$NON-NLS-1$

        try {
            BundleAssertions.assertHasString(bundle, "test_key", false, false); //$NON-NLS-1$
            fail();
        } catch (final AssertionError e) {
            // Expected exception
        }

        try {
            BundleAssertions.assertHasString(bundle, "test_key", false, true); //$NON-NLS-1$
            fail();
        } catch (final AssertionError e) {
            // Expected exception
        }
    }

    @SmallTest
    public static void testHasString_empty_valid() {
        final Bundle bundle = new Bundle();
        bundle.putString("test_key", ""); //$NON-NLS-1$ //$NON-NLS-2$

        BundleAssertions.assertHasString(bundle, "test_key", true, true); //$NON-NLS-1$
        BundleAssertions.assertHasString(bundle, "test_key", false, true); //$NON-NLS-1$
    }

    @SmallTest
    public static void testHasString_empty_invalid() {
        final Bundle bundle = new Bundle();
        bundle.putString("test_key", ""); //$NON-NLS-1$ //$NON-NLS-2$

        try {
            BundleAssertions.assertHasString(bundle, "test_key", false, false); //$NON-NLS-1$
            fail();
        } catch (final AssertionError e) {
            // Expected exception
        }
        try {
            BundleAssertions.assertHasString(bundle, "test_key", true, false); //$NON-NLS-1$
            fail();
        } catch (final AssertionError e) {
            // Expected exception
        }
    }

    @SmallTest
    public static void testAssertKeyCount_valid() {
        BundleAssertions.assertKeyCount(new Bundle(), 0);

        final Bundle bundle = new Bundle();
        bundle.putInt("test_key", 1); //$NON-NLS-1$

        BundleAssertions.assertKeyCount(bundle, 1);
    }

    @SmallTest
    public static void testAssertKeyCount_invalid() {
        try {
            BundleAssertions.assertKeyCount(new Bundle(), 1);
            fail("Should throw exception with incorrect key count"); //$NON-NLS-1$
        } catch (final AssertionError e) {
            // Expected exception
        }

        final Bundle bundle = new Bundle();
        bundle.putInt("test_key", 1); //$NON-NLS-1$

        try {
            BundleAssertions.assertKeyCount(bundle, 0);
            fail("Should throw exception with incorrect key count"); //$NON-NLS-1$
        } catch (final AssertionError e) {
            // Expected exception
        }
    }

    @SmallTest
    public static void testAssertKeyCount_bad_parameters() {
        try {
            BundleAssertions.assertKeyCount(new Bundle(), -1);
            fail("Should throw exception with bad key count"); //$NON-NLS-1$
        } catch (final AssertionError e) {
            // Expected exception
        }
    }
}
