package com.phisher98;

import com.lagradost.api.Log;
import com.lagradost.nicehttp.NiceResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;

/* JADX INFO: compiled from: StreamPlayUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeUhdmovies$$inlined$safeAmap$default$1", f = "StreamPlayExtractor.kt", i = {0, 0}, l = {1898}, m = "invokeSuspend", n = {"$this$coroutineScope", "semaphore"}, nl = {-1}, s = {"L$0", "L$1"}, v = 2)
@SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2265:1\n1739#2:2266\n1814#2,3:2267\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n*L\n1887#1:2266\n1887#1:2267,3\n*E\n"})
public final class StreamPlayExtractor$invokeUhdmovies$$inlined$safeAmap$default$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Unit>>, Object> {
    final /* synthetic */ Function1 $callback$inlined;
    final /* synthetic */ int $concurrency;
    final /* synthetic */ Regex $redirectRegex$inlined;
    final /* synthetic */ Function1 $subtitleCallback$inlined;
    final /* synthetic */ Iterable $this_runCatching;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamPlayExtractor$invokeUhdmovies$$inlined$safeAmap$default$1(int i, Iterable iterable, Continuation continuation, Regex regex, Function1 function1, Function1 function2) {
        super(2, continuation);
        this.$concurrency = i;
        this.$this_runCatching = iterable;
        this.$redirectRegex$inlined = regex;
        this.$subtitleCallback$inlined = function1;
        this.$callback$inlined = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> streamPlayExtractor$invokeUhdmovies$$inlined$safeAmap$default$1 = new StreamPlayExtractor$invokeUhdmovies$$inlined$safeAmap$default$1(this.$concurrency, this.$this_runCatching, continuation, this.$redirectRegex$inlined, this.$subtitleCallback$inlined, this.$callback$inlined);
        streamPlayExtractor$invokeUhdmovies$$inlined$safeAmap$default$1.L$0 = obj;
        return streamPlayExtractor$invokeUhdmovies$$inlined$safeAmap$default$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Unit>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayExtractor$invokeUhdmovies$$inlined$safeAmap$default$1$1 */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "B", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeUhdmovies$$inlined$safeAmap$default$1$1", f = "StreamPlayExtractor.kt", i = {0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 3}, l = {2266, 2271, 2276, 2282}, m = "invokeSuspend", n = {"$this$withPermit$iv", "$this$withPermit$iv", "$completion", "link", "$this$withPermit$iv", "$completion", "link", "$this$withPermit$iv", "$completion", "link", "driveLink"}, nl = {2267, 2272, 2278, 2289}, s = {"L$0", "L$0", "L$2", "L$3", "L$0", "L$2", "L$3", "L$0", "L$2", "L$3", "L$4"}, v = 2)
    @SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreKt\n+ 3 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n*L\n1#1,2265:1\n81#2,3:2266\n85#2,2:2290\n1776#3,21:2269\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n*L\n1889#1:2266,3\n1889#1:2290,2\n*E\n"})
    public static final class C02151 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1 $callback$inlined;
        final /* synthetic */ Object $item;
        final /* synthetic */ Regex $redirectRegex$inlined;
        final /* synthetic */ Semaphore $semaphore;
        final /* synthetic */ Function1 $subtitleCallback$inlined;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02151(Semaphore semaphore, Object obj, Continuation continuation, Regex regex, Function1 function1, Function1 function2) {
            super(2, continuation);
            this.$semaphore = semaphore;
            this.$item = obj;
            this.$redirectRegex$inlined = regex;
            this.$subtitleCallback$inlined = function1;
            this.$callback$inlined = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C02151(this.$semaphore, this.$item, continuation, this.$redirectRegex$inlined, this.$subtitleCallback$inlined, this.$callback$inlined);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:108:0x00b5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:33:0x00c2  */
        /* JADX WARN: Code duplicated, block: B:34:0x00c3 A[Catch: all -> 0x00fa, Exception -> 0x00ff, TRY_LEAVE, TryCatch #12 {Exception -> 0x00ff, all -> 0x00fa, blocks: (B:31:0x00b5, B:34:0x00c3), top: B:108:0x00b5 }] */
        /* JADX WARN: Code duplicated, block: B:36:0x00dc A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:37:0x00dd  */
        /* JADX WARN: Code duplicated, block: B:40:0x00ea A[Catch: all -> 0x006c, Exception -> 0x006f, TRY_LEAVE, TryCatch #1 {Exception -> 0x006f, blocks: (B:12:0x004a, B:38:0x00e6, B:40:0x00ea, B:15:0x0065, B:54:0x0143, B:56:0x0155, B:58:0x015b, B:61:0x0165, B:79:0x01ed), top: B:99:0x000b }] */
        /* JADX WARN: Code duplicated, block: B:42:0x00ef  */
        /* JADX WARN: Code duplicated, block: B:47:0x010b A[Catch: Exception -> 0x0205, all -> 0x021a, TRY_ENTER, TRY_LEAVE, TryCatch #10 {all -> 0x021a, blocks: (B:27:0x009c, B:29:0x00a8, B:47:0x010b), top: B:100:0x009c }] */
        /* JADX WARN: Code duplicated, block: B:52:0x0136 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:53:0x0137  */
        /* JADX WARN: Code duplicated, block: B:56:0x0155 A[Catch: all -> 0x006c, Exception -> 0x006f, TryCatch #1 {Exception -> 0x006f, blocks: (B:12:0x004a, B:38:0x00e6, B:40:0x00ea, B:15:0x0065, B:54:0x0143, B:56:0x0155, B:58:0x015b, B:61:0x0165, B:79:0x01ed), top: B:99:0x000b }] */
        /* JADX WARN: Code duplicated, block: B:68:0x01bc A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:69:0x01bd  */
        public final Object invokeSuspend(Object $result) throws Throwable {
            Semaphore $this$withPermit$iv;
            Semaphore $this$withPermit$iv2;
            Object obj;
            Object obj2;
            int $i$f$withPermit;
            Semaphore $this$withPermit$iv3;
            Continuation $completion;
            String link;
            Object objBypassHrefli;
            Object obj3;
            int $i$f$withPermit2;
            Semaphore $this$withPermit$iv4;
            Continuation $completion2;
            int i;
            Semaphore $this$withPermit$iv5;
            Object obj4;
            Object objSafeGet$default;
            String link2;
            int $i$f$withPermit3;
            Semaphore semaphore;
            Continuation $completion3;
            int i2;
            Object obj5;
            MatchResult matchResultFind$default;
            List groupValues;
            String fileId;
            int $i$f$withPermit4;
            String driveLink;
            Semaphore semaphore2;
            String link3;
            Continuation $completion4;
            Object obj6;
            int i3;
            Semaphore $this$withPermit$iv6;
            Semaphore $this$withPermit$iv7;
            Object objLoadSourceNameExtractor$default;
            Object obj7;
            String str;
            C02151 c02151 = this;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            Object obj8 = null;
            try {
                try {
                    try {
                        switch (c02151.label) {
                            case 0:
                                ResultKt.throwOnFailure($result);
                                Semaphore $this$withPermit$iv8 = c02151.$semaphore;
                                obj2 = c02151.$item;
                                c02151.L$0 = $this$withPermit$iv8;
                                c02151.L$1 = obj2;
                                c02151.label = 1;
                                if ($this$withPermit$iv8.acquire((Continuation) c02151) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                $i$f$withPermit = 0;
                                $this$withPermit$iv3 = $this$withPermit$iv8;
                                try {
                                    try {
                                        $completion = (Continuation) c02151;
                                        link = (String) obj2;
                                        try {
                                            if (!StringsKt.contains(link, "driveleech", true)) {
                                                c02151.L$0 = $this$withPermit$iv3;
                                                c02151.L$1 = obj2;
                                                c02151.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                                                c02151.L$3 = link;
                                                c02151.label = 2;
                                                $this$withPermit$iv5 = $this$withPermit$iv3;
                                                obj4 = obj2;
                                                objSafeGet$default = StreamPlayUtilsKt.safeGet$default(link, null, null, null, null, false, 0, this, 126, null);
                                                c02151 = this;
                                                if (objSafeGet$default == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                link2 = link;
                                                $i$f$withPermit3 = $i$f$withPermit;
                                                semaphore = null;
                                                $completion3 = $completion;
                                                i2 = 0;
                                                obj5 = obj4;
                                                $this$withPermit$iv = $this$withPermit$iv5;
                                                String text = ((NiceResponse) objSafeGet$default).getText();
                                                matchResultFind$default = Regex.find$default(c02151.$redirectRegex$inlined, text, 0, 2, (Object) null);
                                                if (matchResultFind$default != null) {
                                                }
                                                obj8 = Unit.INSTANCE;
                                            } else {
                                                try {
                                                    if (StringsKt.contains(link, "driveseed", true)) {
                                                        c02151.L$0 = $this$withPermit$iv3;
                                                        c02151.L$1 = obj2;
                                                        c02151.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                                                        c02151.L$3 = link;
                                                        c02151.label = 2;
                                                        $this$withPermit$iv5 = $this$withPermit$iv3;
                                                        obj4 = obj2;
                                                        try {
                                                            objSafeGet$default = StreamPlayUtilsKt.safeGet$default(link, null, null, null, null, false, 0, this, 126, null);
                                                            c02151 = this;
                                                            if (objSafeGet$default == coroutine_suspended) {
                                                                return coroutine_suspended;
                                                            }
                                                            link2 = link;
                                                            $i$f$withPermit3 = $i$f$withPermit;
                                                            semaphore = null;
                                                            $completion3 = $completion;
                                                            i2 = 0;
                                                            obj5 = obj4;
                                                            $this$withPermit$iv = $this$withPermit$iv5;
                                                            String text2 = ((NiceResponse) objSafeGet$default).getText();
                                                            matchResultFind$default = Regex.find$default(c02151.$redirectRegex$inlined, text2, 0, 2, (Object) null);
                                                            if (matchResultFind$default != null || (groupValues = matchResultFind$default.getGroupValues()) == null || (fileId = (String) CollectionsKt.getOrNull(groupValues, 1)) == null) {
                                                                obj8 = Unit.INSTANCE;
                                                            } else {
                                                                $i$f$withPermit4 = $i$f$withPermit3;
                                                                driveLink = StreamPlayUtilsKt.getBaseUrl(link2) + fileId;
                                                                semaphore2 = semaphore;
                                                                link3 = link2;
                                                                $completion4 = $completion3;
                                                                obj6 = obj5;
                                                                i3 = i2;
                                                                $this$withPermit$iv6 = $this$withPermit$iv;
                                                                try {
                                                                    Function1 function1 = c02151.$subtitleCallback$inlined;
                                                                    Function1 function2 = c02151.$callback$inlined;
                                                                    c02151.L$0 = $this$withPermit$iv6;
                                                                    c02151.L$1 = obj6;
                                                                    c02151.L$2 = SpillingKt.nullOutSpilledVariable($completion4);
                                                                    c02151.L$3 = SpillingKt.nullOutSpilledVariable(link3);
                                                                    c02151.L$4 = SpillingKt.nullOutSpilledVariable(driveLink);
                                                                    c02151.label = 4;
                                                                    $this$withPermit$iv7 = $this$withPermit$iv6;
                                                                    Object obj9 = obj6;
                                                                    try {
                                                                        objLoadSourceNameExtractor$default = StreamPlayUtilsKt.loadSourceNameExtractor$default("UHDMovies", driveLink, "", function1, function2, null, null, c02151, 96, null);
                                                                        if (objLoadSourceNameExtractor$default == coroutine_suspended) {
                                                                            return coroutine_suspended;
                                                                        }
                                                                        $this$withPermit$iv = $this$withPermit$iv7;
                                                                        obj7 = objLoadSourceNameExtractor$default;
                                                                        obj8 = obj7;
                                                                    } catch (Exception e) {
                                                                        e = e;
                                                                        $this$withPermit$iv = $this$withPermit$iv7;
                                                                        obj = obj9;
                                                                        Log.INSTANCE.e("safeMap", "Request failed for " + obj + ' ' + e);
                                                                    } catch (Throwable th) {
                                                                        th = th;
                                                                        $this$withPermit$iv2 = $this$withPermit$iv7;
                                                                        $this$withPermit$iv2.release();
                                                                        throw th;
                                                                    }
                                                                } catch (Exception e2) {
                                                                    e = e2;
                                                                    $this$withPermit$iv = $this$withPermit$iv6;
                                                                    obj = obj6;
                                                                } catch (Throwable th2) {
                                                                    th = th2;
                                                                    $this$withPermit$iv2 = $this$withPermit$iv6;
                                                                }
                                                            }
                                                        } catch (Exception e3) {
                                                            $this$withPermit$iv = $this$withPermit$iv5;
                                                            obj8 = Unit.INSTANCE;
                                                        } catch (Throwable th3) {
                                                            th = th3;
                                                            $this$withPermit$iv2 = $this$withPermit$iv5;
                                                            $this$withPermit$iv2.release();
                                                            throw th;
                                                        }
                                                    } else {
                                                        c02151.L$0 = $this$withPermit$iv3;
                                                        c02151.L$1 = obj2;
                                                        c02151.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                                                        c02151.L$3 = SpillingKt.nullOutSpilledVariable(link);
                                                        c02151.label = 3;
                                                        objBypassHrefli = StreamPlayUtilsKt.bypassHrefli(link, c02151);
                                                        if (objBypassHrefli == coroutine_suspended) {
                                                            return coroutine_suspended;
                                                        }
                                                        obj3 = obj2;
                                                        $this$withPermit$iv = $this$withPermit$iv3;
                                                        $i$f$withPermit2 = $i$f$withPermit;
                                                        $this$withPermit$iv4 = null;
                                                        $completion2 = $completion;
                                                        i = 0;
                                                        str = (String) objBypassHrefli;
                                                        if (str == null) {
                                                            obj8 = Unit.INSTANCE;
                                                        } else {
                                                            $i$f$withPermit4 = $i$f$withPermit2;
                                                            driveLink = str;
                                                            semaphore2 = $this$withPermit$iv4;
                                                            i3 = i;
                                                            link3 = link;
                                                            $completion4 = $completion2;
                                                            obj6 = obj3;
                                                            $this$withPermit$iv6 = $this$withPermit$iv;
                                                            Function1 function3 = c02151.$subtitleCallback$inlined;
                                                            Function1 function4 = c02151.$callback$inlined;
                                                            c02151.L$0 = $this$withPermit$iv6;
                                                            c02151.L$1 = obj6;
                                                            c02151.L$2 = SpillingKt.nullOutSpilledVariable($completion4);
                                                            c02151.L$3 = SpillingKt.nullOutSpilledVariable(link3);
                                                            c02151.L$4 = SpillingKt.nullOutSpilledVariable(driveLink);
                                                            c02151.label = 4;
                                                            $this$withPermit$iv7 = $this$withPermit$iv6;
                                                            Object obj10 = obj6;
                                                            objLoadSourceNameExtractor$default = StreamPlayUtilsKt.loadSourceNameExtractor$default("UHDMovies", driveLink, "", function3, function4, null, null, c02151, 96, null);
                                                            if (objLoadSourceNameExtractor$default == coroutine_suspended) {
                                                                return coroutine_suspended;
                                                            }
                                                            $this$withPermit$iv = $this$withPermit$iv7;
                                                            obj7 = objLoadSourceNameExtractor$default;
                                                            obj8 = obj7;
                                                        }
                                                    }
                                                } catch (Exception e4) {
                                                    $this$withPermit$iv = $this$withPermit$iv3;
                                                } catch (Throwable th4) {
                                                    th = th4;
                                                    $this$withPermit$iv2 = $this$withPermit$iv3;
                                                    $this$withPermit$iv2.release();
                                                    throw th;
                                                }
                                                obj8 = Unit.INSTANCE;
                                            }
                                        } catch (Exception e5) {
                                            $this$withPermit$iv = $this$withPermit$iv3;
                                        }
                                    } catch (Throwable th5) {
                                        th = th5;
                                        $this$withPermit$iv2 = $this$withPermit$iv3;
                                    }
                                } catch (Exception e6) {
                                    e = e6;
                                    obj = obj2;
                                    $this$withPermit$iv = $this$withPermit$iv3;
                                    Log.INSTANCE.e("safeMap", "Request failed for " + obj + ' ' + e);
                                    $this$withPermit$iv.release();
                                    return obj8;
                                }
                                $this$withPermit$iv.release();
                                return obj8;
                            case 1:
                                obj2 = c02151.L$1;
                                $this$withPermit$iv3 = (Semaphore) c02151.L$0;
                                ResultKt.throwOnFailure($result);
                                $i$f$withPermit = 0;
                                $completion = (Continuation) c02151;
                                link = (String) obj2;
                                if (!StringsKt.contains(link, "driveleech", true)) {
                                    c02151.L$0 = $this$withPermit$iv3;
                                    c02151.L$1 = obj2;
                                    c02151.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                                    c02151.L$3 = link;
                                    c02151.label = 2;
                                    $this$withPermit$iv5 = $this$withPermit$iv3;
                                    obj4 = obj2;
                                    objSafeGet$default = StreamPlayUtilsKt.safeGet$default(link, null, null, null, null, false, 0, this, 126, null);
                                    c02151 = this;
                                    if (objSafeGet$default == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    link2 = link;
                                    $i$f$withPermit3 = $i$f$withPermit;
                                    semaphore = null;
                                    $completion3 = $completion;
                                    i2 = 0;
                                    obj5 = obj4;
                                    $this$withPermit$iv = $this$withPermit$iv5;
                                    String text3 = ((NiceResponse) objSafeGet$default).getText();
                                    matchResultFind$default = Regex.find$default(c02151.$redirectRegex$inlined, text3, 0, 2, (Object) null);
                                    if (matchResultFind$default != null) {
                                    }
                                    obj8 = Unit.INSTANCE;
                                    break;
                                } else {
                                    if (StringsKt.contains(link, "driveseed", true)) {
                                        c02151.L$0 = $this$withPermit$iv3;
                                        c02151.L$1 = obj2;
                                        c02151.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                                        c02151.L$3 = link;
                                        c02151.label = 2;
                                        $this$withPermit$iv5 = $this$withPermit$iv3;
                                        obj4 = obj2;
                                        objSafeGet$default = StreamPlayUtilsKt.safeGet$default(link, null, null, null, null, false, 0, this, 126, null);
                                        c02151 = this;
                                        if (objSafeGet$default == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        link2 = link;
                                        $i$f$withPermit3 = $i$f$withPermit;
                                        semaphore = null;
                                        $completion3 = $completion;
                                        i2 = 0;
                                        obj5 = obj4;
                                        $this$withPermit$iv = $this$withPermit$iv5;
                                        String text4 = ((NiceResponse) objSafeGet$default).getText();
                                        matchResultFind$default = Regex.find$default(c02151.$redirectRegex$inlined, text4, 0, 2, (Object) null);
                                        if (matchResultFind$default != null) {
                                        }
                                        obj8 = Unit.INSTANCE;
                                        break;
                                    } else {
                                        c02151.L$0 = $this$withPermit$iv3;
                                        c02151.L$1 = obj2;
                                        c02151.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                                        c02151.L$3 = SpillingKt.nullOutSpilledVariable(link);
                                        c02151.label = 3;
                                        objBypassHrefli = StreamPlayUtilsKt.bypassHrefli(link, c02151);
                                        if (objBypassHrefli == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        obj3 = obj2;
                                        $this$withPermit$iv = $this$withPermit$iv3;
                                        $i$f$withPermit2 = $i$f$withPermit;
                                        $this$withPermit$iv4 = null;
                                        $completion2 = $completion;
                                        i = 0;
                                        str = (String) objBypassHrefli;
                                        if (str == null) {
                                            obj8 = Unit.INSTANCE;
                                        } else {
                                            $i$f$withPermit4 = $i$f$withPermit2;
                                            driveLink = str;
                                            semaphore2 = $this$withPermit$iv4;
                                            i3 = i;
                                            link3 = link;
                                            $completion4 = $completion2;
                                            obj6 = obj3;
                                            $this$withPermit$iv6 = $this$withPermit$iv;
                                            Function1 function5 = c02151.$subtitleCallback$inlined;
                                            Function1 function6 = c02151.$callback$inlined;
                                            c02151.L$0 = $this$withPermit$iv6;
                                            c02151.L$1 = obj6;
                                            c02151.L$2 = SpillingKt.nullOutSpilledVariable($completion4);
                                            c02151.L$3 = SpillingKt.nullOutSpilledVariable(link3);
                                            c02151.L$4 = SpillingKt.nullOutSpilledVariable(driveLink);
                                            c02151.label = 4;
                                            $this$withPermit$iv7 = $this$withPermit$iv6;
                                            Object obj11 = obj6;
                                            objLoadSourceNameExtractor$default = StreamPlayUtilsKt.loadSourceNameExtractor$default("UHDMovies", driveLink, "", function5, function6, null, null, c02151, 96, null);
                                            if (objLoadSourceNameExtractor$default == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            $this$withPermit$iv = $this$withPermit$iv7;
                                            obj7 = objLoadSourceNameExtractor$default;
                                            obj8 = obj7;
                                        }
                                    }
                                    obj8 = Unit.INSTANCE;
                                }
                                $this$withPermit$iv.release();
                                return obj8;
                            case 2:
                                $i$f$withPermit3 = 0;
                                semaphore = null;
                                i2 = 0;
                                link2 = (String) c02151.L$3;
                                $completion3 = (Continuation) c02151.L$2;
                                obj5 = c02151.L$1;
                                $this$withPermit$iv = (Semaphore) c02151.L$0;
                                ResultKt.throwOnFailure($result);
                                objSafeGet$default = $result;
                                String text5 = ((NiceResponse) objSafeGet$default).getText();
                                matchResultFind$default = Regex.find$default(c02151.$redirectRegex$inlined, text5, 0, 2, (Object) null);
                                if (matchResultFind$default != null) {
                                    break;
                                }
                                obj8 = Unit.INSTANCE;
                                $this$withPermit$iv.release();
                                return obj8;
                            case 3:
                                $i$f$withPermit2 = 0;
                                $this$withPermit$iv4 = null;
                                i = 0;
                                link = (String) c02151.L$3;
                                $completion2 = (Continuation) c02151.L$2;
                                obj3 = c02151.L$1;
                                $this$withPermit$iv = (Semaphore) c02151.L$0;
                                ResultKt.throwOnFailure($result);
                                objBypassHrefli = $result;
                                str = (String) objBypassHrefli;
                                if (str == null) {
                                    obj8 = Unit.INSTANCE;
                                } else {
                                    $i$f$withPermit4 = $i$f$withPermit2;
                                    driveLink = str;
                                    semaphore2 = $this$withPermit$iv4;
                                    i3 = i;
                                    link3 = link;
                                    $completion4 = $completion2;
                                    obj6 = obj3;
                                    $this$withPermit$iv6 = $this$withPermit$iv;
                                    Function1 function7 = c02151.$subtitleCallback$inlined;
                                    Function1 function8 = c02151.$callback$inlined;
                                    c02151.L$0 = $this$withPermit$iv6;
                                    c02151.L$1 = obj6;
                                    c02151.L$2 = SpillingKt.nullOutSpilledVariable($completion4);
                                    c02151.L$3 = SpillingKt.nullOutSpilledVariable(link3);
                                    c02151.L$4 = SpillingKt.nullOutSpilledVariable(driveLink);
                                    c02151.label = 4;
                                    $this$withPermit$iv7 = $this$withPermit$iv6;
                                    Object obj12 = obj6;
                                    objLoadSourceNameExtractor$default = StreamPlayUtilsKt.loadSourceNameExtractor$default("UHDMovies", driveLink, "", function7, function8, null, null, c02151, 96, null);
                                    if (objLoadSourceNameExtractor$default == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    $this$withPermit$iv = $this$withPermit$iv7;
                                    obj7 = objLoadSourceNameExtractor$default;
                                    obj8 = obj7;
                                }
                                $this$withPermit$iv.release();
                                return obj8;
                            case 4:
                                Object obj13 = c02151.L$1;
                                $this$withPermit$iv = (Semaphore) c02151.L$0;
                                ResultKt.throwOnFailure($result);
                                $i$f$withPermit4 = 0;
                                obj7 = $result;
                                obj8 = obj7;
                                $this$withPermit$iv.release();
                                return obj8;
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } catch (Exception e7) {
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Exception e8) {
                e = e8;
            }
        }
    }

    public final Object invokeSuspend(Object $result) {
        Object objAwaitAll;
        CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Semaphore semaphore = SemaphoreKt.Semaphore$default(this.$concurrency, 0, 2, (Object) null);
                Iterable $this$map$iv = this.$this_runCatching;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    Collection destination$iv$iv2 = destination$iv$iv;
                    destination$iv$iv2.add(BuildersKt.async$default($this$coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new C02151(semaphore, item$iv$iv, null, this.$redirectRegex$inlined, this.$subtitleCallback$inlined, this.$callback$inlined), 2, (Object) null));
                    destination$iv$iv = destination$iv$iv2;
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$coroutineScope);
                this.L$1 = SpillingKt.nullOutSpilledVariable(semaphore);
                this.label = 1;
                objAwaitAll = AwaitKt.awaitAll((List) destination$iv$iv, (Continuation) this);
                if (objAwaitAll == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                objAwaitAll = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return CollectionsKt.filterNotNull((Iterable) objAwaitAll);
    }
}
