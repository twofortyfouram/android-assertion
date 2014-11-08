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

import com.twofortyfouram.assertion.Assertions;
import com.twofortyfouram.test.assertion.MoarAsserts;

import junit.framework.TestCase;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.test.suitebuilder.annotation.SmallTest;
import android.text.format.DateUtils;

import java.util.Collection;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Tests {@link com.twofortyfouram.assertion.Assertions}.
 */
public final class AssertionsTest extends TestCase {

    @SmallTest
    public static void testNonInstantiable() {
        MoarAsserts.assertNoninstantiable(Assertions.class);
    }

    @SmallTest
         public static void testAssertInRangeInclusive_int_below() {
        try {
            Assertions.assertInRangeInclusive(-1, 0, 5, "test");  //$NON-NLS-1$
        }
        catch (final AssertionError e) {
            // Expected exception
        }
    }

    @SmallTest
    public static void testAssertInRangeInclusive_int_in_range() {
        Assertions.assertInRangeInclusive(0, 0, 5, "test");  //$NON-NLS-1$
        Assertions.assertInRangeInclusive(3, 0, 5, "test");  //$NON-NLS-1$
        Assertions.assertInRangeInclusive(5, 0, 5, "test");  //$NON-NLS-1$
    }

    @SmallTest
    public static void testAssertInRangeInclusive_int_above() {
        try {
            Assertions.assertInRangeInclusive(6, 0, 5, "test");  //$NON-NLS-1$
        }
        catch (final AssertionError e) {
            // Expected exception
        }
    }

    @SmallTest
    public static void testAssertInRangeInclusive_long_below() {
        try {
            Assertions.assertInRangeInclusive(-1l, 0l, 5l, "test");  //$NON-NLS-1$
        }
        catch (final AssertionError e) {
            // Expected exception
        }
    }

    @SmallTest
    public static void testAssertInRangeInclusive_long_in_range() {
        Assertions.assertInRangeInclusive(0l, 0l, 5l, "test");  //$NON-NLS-1$
        Assertions.assertInRangeInclusive(3l, 0l, 5l, "test");  //$NON-NLS-1$
        Assertions.assertInRangeInclusive(5l, 0l, 5l, "test");  //$NON-NLS-1$
    }

    @SmallTest
    public static void testAssertInRangeInclusive_long_above() {
        try {
            Assertions.assertInRangeInclusive(6l, 0l, 5l, "test");  //$NON-NLS-1$
        }
        catch (final AssertionError e) {
            // Expected exception
        }
    }

    @SmallTest
    public static void testAssertInRangeInclusive_float_below() {
        try {
            Assertions.assertInRangeInclusive(-1f, 0f, 5f, "test");  //$NON-NLS-1$
        }
        catch (final AssertionError e) {
            // Expected exception
        }
    }

    @SmallTest
    public static void testAssertInRangeInclusive_float_in_range() {
        Assertions.assertInRangeInclusive(0f, 0f, 5f, "test");  //$NON-NLS-1$
        Assertions.assertInRangeInclusive(3f, 0f, 5f, "test");  //$NON-NLS-1$
        Assertions.assertInRangeInclusive(5f, 0f, 5f, "test");  //$NON-NLS-1$
    }

    @SmallTest
    public static void testAssertInRangeInclusive_float_above() {
        try {
            Assertions.assertInRangeInclusive(6f, 0f, 5f, "test");  //$NON-NLS-1$
        }
        catch (final AssertionError e) {
            // Expected exception
        }
    }

    @SmallTest
    public static void testAssertInRangeInclusive_double_below() {
        try {
            Assertions.assertInRangeInclusive(-1d, 0d, 5d, "test");  //$NON-NLS-1$
        }
        catch (final AssertionError e) {
            // Expected exception
        }
    }

    @SmallTest
    public static void testAssertInRangeInclusive_double_in_range() {
        Assertions.assertInRangeInclusive(0d, 0d, 5d, "test");  //$NON-NLS-1$
        Assertions.assertInRangeInclusive(3d, 0d, 5d, "test");  //$NON-NLS-1$
        Assertions.assertInRangeInclusive(5d, 0d, 5d, "test");  //$NON-NLS-1$
    }

    @SmallTest
    public static void testAssertInRangeInclusive_double_above() {
        try {
            Assertions.assertInRangeInclusive(6d, 0d, 5d, "test");  //$NON-NLS-1$
        }
        catch (final AssertionError e) {
            // Expected exception
        }
    }

    @SmallTest
    public static void testAssertNoNullElements_collection_non_empty() {
        final LinkedList<String> list = new LinkedList<String>();
        list.add("test"); //$NON-NLS-1$

        Assertions.assertNoNullElements(list, "test"); //$NON-NLS-1$
    }

    @SmallTest
    public static void testAssertNoNullElements_collection_empty() {
        Assertions.assertNoNullElements(new LinkedList<String>(), "test"); //$NON-NLS-1$
    }

    @SmallTest
    public static void testAssertNoNullElements_collection_null_collection() {
        try {
            Assertions.assertNoNullElements((Collection)null, "test"); //$NON-NLS-1$
            fail();
        } catch (final AssertionError e) {
            // Expected exception
        }
    }

    @SmallTest
    public static void testAssertNoNullElements_collection_null_element() {
        final LinkedList<String> list = new LinkedList<String>();
        list.add("test"); //$NON-NLS-1$
        list.add(null);

        try {
            Assertions.assertNoNullElements(list, "test"); //$NON-NLS-1$
            fail();
        } catch (final AssertionError e) {
            // Expected exception
        }
    }

    @SmallTest
    public static void testAssertNoNullElements_array_non_empty() {
        final String[] array = new String[] {"foo"}; //$NON-NLS-1$

        Assertions.assertNoNullElements(array, "test"); //$NON-NLS-1$
    }

    @SmallTest
    public static void testAssertNoNullElements_array_empty() {
        final String[] array = new String[0];

        Assertions.assertNoNullElements(array, "test"); //$NON-NLS-1$
    }

    @SmallTest
    public static void testAssertNoNullElements_array_null_collection() {
        try {
            Assertions.assertNoNullElements((Object[])null, "test"); //$NON-NLS-1$
            fail();
        } catch (final AssertionError e) {
            // Expected exception
        }
    }

    @SmallTest
    public static void testAssertNoNullElements_array_null_element() {
        final String[] array = new String[] {"foo", null}; //$NON-NLS-1$

        try {
            Assertions.assertNoNullElements(array, "test"); //$NON-NLS-1$
            fail();
        } catch (final AssertionError e) {
            // Expected exception
        }
    }

    @SmallTest
    public static void testAssertInSet() {
        Assertions.assertInSet("test", "test"); //$NON-NLS-1$ //$NON-NLS-2$
        Assertions.assertInSet("test", "foo", "test"); //$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$
        Assertions.assertInSet("test", "test", "foo"); //$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$
    }

    @SmallTest
    public static void testAssertInSet_empty() {
        try {
            Assertions.assertInSet("test", (Object[]) new String[]{}); //$NON-NLS-1$
            fail();
        } catch (final AssertionError e) {
            // Expected exception
        }
    }

    @SmallTest
    public static void testAssertInSet_null() {
        Assertions.assertInSet("test", null, "test"); //$NON-NLS-1$ //$NON-NLS-2$
    }

    @SmallTest
    public static void testAssertNotNull_not_null() {
        Assertions.assertNotNull("test", "test"); //$NON-NLS-1$//$NON-NLS-2$
    }

    @SmallTest
    public static void testAssertNotNull_null() {
        try {
            Assertions.assertNotNull(null, "test"); //$NON-NLS-1$
            fail("AssertionError should have been thrown"); //$NON-NLS-1$
        } catch (final AssertionError e) {
            // Expected exception
        }
    }

    @SmallTest
    public static void testAssertNotEmpty_empty() {
        try {
            Assertions.assertNotEmpty("", "test"); //$NON-NLS-1$ //$NON-NLS-2$
            fail("AssertionError should have been thrown"); //$NON-NLS-1$
        } catch (final AssertionError e) {
            // Expected exception
        }
    }

    @SmallTest
    public static void testAssertNotEmpty_not_empty() {
        Assertions.assertNotEmpty("test", "test"); //$NON-NLS-1$//$NON-NLS-2$
    }

    @SmallTest
    public static void testAssertNotEmpty_null() {
        try {
            Assertions.assertNotEmpty(null, "test"); //$NON-NLS-1$
            fail("AssertionError should have been thrown"); //$NON-NLS-1$
        } catch (final AssertionError e) {
            // Expected exception
        }
    }

    @SmallTest
    public void testAssertIsMainThread_not_on_main() throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(1);

        HandlerThread thread = null;
        try {
            thread = new HandlerThread(getName(), android.os.Process.THREAD_PRIORITY_DEFAULT);
            thread.start();
            new Handler(thread.getLooper()).post(new Runnable() {

                @Override
                public void run() {
                    try {
                        Assertions.assertIsMainThread();
                        fail();
                    } catch (final AssertionError e) {
                        // Expected exception
                    }

                    latch.countDown();
                }

            });

            assertTrue(latch.await(250, TimeUnit.MILLISECONDS));
        } finally {
            if (null != thread) {
                thread.getLooper().quit();
            }
        }
    }

    @SmallTest
    public static void testAssertIsMainThread_on_main() throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(1);

        new Handler(Looper.getMainLooper()).post(new Runnable() {

            @Override
            public void run() {
                Assertions.assertIsMainThread();

                latch.countDown();
            }

        });

        assertTrue(latch.await(1 * DateUtils.SECOND_IN_MILLIS, TimeUnit.MILLISECONDS));
    }
}
