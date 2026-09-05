package com.phisher98;

import com.lagradost.api.Log;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.M3u8Helper;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
import okhttp3.Interceptor;

/* JADX INFO: compiled from: StreamPlayUtils.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeMapple$$inlined$safeAmap$default$1", f = "StreamPlayExtractor.kt", i = {0, 0}, l = {1898}, m = "invokeSuspend", n = {"$this$coroutineScope", "semaphore"}, nl = {-1}, s = {"L$0", "L$1"}, v = 2)
@SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2265:1\n1739#2:2266\n1814#2,3:2267\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n*L\n1887#1:2266\n1887#1:2267,3\n*E\n"})
public final class StreamPlayExtractor$invokeMapple$$inlined$safeAmap$default$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Unit>>, Object> {
    final /* synthetic */ String $base$inlined;
    final /* synthetic */ Function1 $callback$inlined;
    final /* synthetic */ int $concurrency;
    final /* synthetic */ String $finalToken$inlined;
    final /* synthetic */ Ref.BooleanRef $foundStreams$inlined;
    final /* synthetic */ Map $headers$inlined;
    final /* synthetic */ String $mediaType$inlined;
    final /* synthetic */ String $requestToken$inlined;
    final /* synthetic */ Iterable $this_runCatching;
    final /* synthetic */ Integer $tmdbId$inlined;
    final /* synthetic */ String $tvSlug$inlined;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamPlayExtractor$invokeMapple$$inlined$safeAmap$default$1(int i, Iterable iterable, Continuation continuation, String str, Integer num, String str2, String str3, String str4, String str5, Map map, Function1 function1, Ref.BooleanRef booleanRef) {
        super(2, continuation);
        this.$concurrency = i;
        this.$this_runCatching = iterable;
        this.$base$inlined = str;
        this.$tmdbId$inlined = num;
        this.$mediaType$inlined = str2;
        this.$tvSlug$inlined = str3;
        this.$requestToken$inlined = str4;
        this.$finalToken$inlined = str5;
        this.$headers$inlined = map;
        this.$callback$inlined = function1;
        this.$foundStreams$inlined = booleanRef;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> streamPlayExtractor$invokeMapple$$inlined$safeAmap$default$1 = new StreamPlayExtractor$invokeMapple$$inlined$safeAmap$default$1(this.$concurrency, this.$this_runCatching, continuation, this.$base$inlined, this.$tmdbId$inlined, this.$mediaType$inlined, this.$tvSlug$inlined, this.$requestToken$inlined, this.$finalToken$inlined, this.$headers$inlined, this.$callback$inlined, this.$foundStreams$inlined);
        streamPlayExtractor$invokeMapple$$inlined$safeAmap$default$1.L$0 = obj;
        return streamPlayExtractor$invokeMapple$$inlined$safeAmap$default$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Unit>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayExtractor$invokeMapple$$inlined$safeAmap$default$1$1 */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "B", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeMapple$$inlined$safeAmap$default$1$1", f = "StreamPlayExtractor.kt", i = {0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2}, l = {2266, 2275, 2287}, m = "invokeSuspend", n = {"$this$withPermit$iv", "$this$withPermit$iv", "$completion", "sourceId", "sourceName", "streamUrl", "$this$withPermit$iv", "$completion", "sourceId", "sourceName", "streamUrl", "m3u8", "streamRes"}, nl = {2267, 2276, 2292}, s = {"L$0", "L$0", "L$2", "L$3", "L$4", "L$5", "L$0", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7"}, v = 2)
    @SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreKt\n+ 3 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n+ 4 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2265:1\n81#2,3:2266\n85#2,2:2300\n2110#3,7:2269\n2118#3,12:2281\n2130#3,3:2294\n2135#3,2:2298\n73#4,5:2276\n2068#5:2293\n2069#5:2297\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n*L\n1889#1:2266,3\n1889#1:2300,2\n2116#2:2276,5\n2129#2:2293\n2129#2:2297\n*E\n"})
    public static final class C01751 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $base$inlined;
        final /* synthetic */ Function1 $callback$inlined;
        final /* synthetic */ String $finalToken$inlined;
        final /* synthetic */ Ref.BooleanRef $foundStreams$inlined;
        final /* synthetic */ Map $headers$inlined;
        final /* synthetic */ Object $item;
        final /* synthetic */ String $mediaType$inlined;
        final /* synthetic */ String $requestToken$inlined;
        final /* synthetic */ Semaphore $semaphore;
        final /* synthetic */ Integer $tmdbId$inlined;
        final /* synthetic */ String $tvSlug$inlined;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01751(Semaphore semaphore, Object obj, Continuation continuation, String str, Integer num, String str2, String str3, String str4, String str5, Map map, Function1 function1, Ref.BooleanRef booleanRef) {
            super(2, continuation);
            this.$semaphore = semaphore;
            this.$item = obj;
            this.$base$inlined = str;
            this.$tmdbId$inlined = num;
            this.$mediaType$inlined = str2;
            this.$tvSlug$inlined = str3;
            this.$requestToken$inlined = str4;
            this.$finalToken$inlined = str5;
            this.$headers$inlined = map;
            this.$callback$inlined = function1;
            this.$foundStreams$inlined = booleanRef;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C01751(this.$semaphore, this.$item, continuation, this.$base$inlined, this.$tmdbId$inlined, this.$mediaType$inlined, this.$tvSlug$inlined, this.$requestToken$inlined, this.$finalToken$inlined, this.$headers$inlined, this.$callback$inlined, this.$foundStreams$inlined);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:33:0x0171 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:34:0x0172  */
        /* JADX WARN: Code duplicated, block: B:43:0x01a0 A[Catch: all -> 0x02f9, Exception -> 0x02fe, TryCatch #11 {Exception -> 0x02fe, blocks: (B:35:0x0179, B:41:0x019a, B:43:0x01a0, B:46:0x01b0, B:48:0x01b6, B:51:0x01be, B:56:0x01cc, B:58:0x01db, B:67:0x020f, B:62:0x01eb, B:66:0x0206, B:40:0x0195), top: B:121:0x0179 }] */
        /* JADX WARN: Code duplicated, block: B:44:0x01ad  */
        /* JADX WARN: Code duplicated, block: B:46:0x01b0 A[Catch: all -> 0x02f9, Exception -> 0x02fe, TryCatch #11 {Exception -> 0x02fe, blocks: (B:35:0x0179, B:41:0x019a, B:43:0x01a0, B:46:0x01b0, B:48:0x01b6, B:51:0x01be, B:56:0x01cc, B:58:0x01db, B:67:0x020f, B:62:0x01eb, B:66:0x0206, B:40:0x0195), top: B:121:0x0179 }] */
        /* JADX WARN: Code duplicated, block: B:48:0x01b6 A[Catch: all -> 0x02f9, Exception -> 0x02fe, TryCatch #11 {Exception -> 0x02fe, blocks: (B:35:0x0179, B:41:0x019a, B:43:0x01a0, B:46:0x01b0, B:48:0x01b6, B:51:0x01be, B:56:0x01cc, B:58:0x01db, B:67:0x020f, B:62:0x01eb, B:66:0x0206, B:40:0x0195), top: B:121:0x0179 }] */
        /* JADX WARN: Code duplicated, block: B:50:0x01bc  */
        /* JADX WARN: Code duplicated, block: B:53:0x01c7  */
        /* JADX WARN: Code duplicated, block: B:54:0x01c9  */
        /* JADX WARN: Code duplicated, block: B:56:0x01cc A[Catch: all -> 0x02f9, Exception -> 0x02fe, TryCatch #11 {Exception -> 0x02fe, blocks: (B:35:0x0179, B:41:0x019a, B:43:0x01a0, B:46:0x01b0, B:48:0x01b6, B:51:0x01be, B:56:0x01cc, B:58:0x01db, B:67:0x020f, B:62:0x01eb, B:66:0x0206, B:40:0x0195), top: B:121:0x0179 }] */
        /* JADX WARN: Code duplicated, block: B:58:0x01db A[Catch: all -> 0x02f9, Exception -> 0x02fe, TryCatch #11 {Exception -> 0x02fe, blocks: (B:35:0x0179, B:41:0x019a, B:43:0x01a0, B:46:0x01b0, B:48:0x01b6, B:51:0x01be, B:56:0x01cc, B:58:0x01db, B:67:0x020f, B:62:0x01eb, B:66:0x0206, B:40:0x0195), top: B:121:0x0179 }] */
        /* JADX WARN: Code duplicated, block: B:62:0x01eb A[Catch: all -> 0x02f9, Exception -> 0x02fe, TryCatch #11 {Exception -> 0x02fe, blocks: (B:35:0x0179, B:41:0x019a, B:43:0x01a0, B:46:0x01b0, B:48:0x01b6, B:51:0x01be, B:56:0x01cc, B:58:0x01db, B:67:0x020f, B:62:0x01eb, B:66:0x0206, B:40:0x0195), top: B:121:0x0179 }] */
        /* JADX WARN: Code duplicated, block: B:64:0x0201  */
        /* JADX WARN: Code duplicated, block: B:65:0x0204  */
        /* JADX WARN: Code duplicated, block: B:69:0x028d A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:70:0x028e  */
        /* JADX WARN: Code duplicated, block: B:74:0x02a9 A[Catch: all -> 0x02eb, Exception -> 0x02f0, TRY_LEAVE, TryCatch #17 {Exception -> 0x02f0, all -> 0x02eb, blocks: (B:71:0x029b, B:72:0x02a3, B:74:0x02a9), top: B:126:0x029b }] */
        public final Object invokeSuspend(Object $result) throws Throwable {
            Semaphore $this$withPermit$iv;
            Object obj;
            int $i$f$withPermit;
            Semaphore $this$withPermit$iv2;
            int i;
            Continuation $completion;
            int i2;
            String sourceId;
            String sourceName;
            int i3;
            Continuation $completion2;
            int $i$f$withPermit2;
            String sourceId2;
            String sourceId3;
            Object obj2;
            String streamUrl;
            Object obj3;
            Semaphore $this$withPermit$iv3;
            String sourceId4;
            boolean z;
            Object obj4;
            String sourceId5;
            String sourceName2;
            Object safe;
            MappleStreamRes streamRes;
            boolean zAreEqual;
            MappleStreamData data;
            String m3u8;
            boolean z2;
            String str;
            String m3u9;
            Object objGenerateM3u8$default;
            int $i$f$withPermit3;
            Unit unit;
            Iterable $this$forEach$iv;
            C01751 c01751 = this;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (c01751.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Semaphore $this$withPermit$iv4 = c01751.$semaphore;
                        obj = c01751.$item;
                        c01751.L$0 = $this$withPermit$iv4;
                        c01751.L$1 = obj;
                        c01751.label = 1;
                        if ($this$withPermit$iv4.acquire((Continuation) c01751) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $i$f$withPermit = 0;
                        $this$withPermit$iv2 = $this$withPermit$iv4;
                        i = 0;
                        try {
                            try {
                                Pair pair = (Pair) obj;
                                $completion = (Continuation) c01751;
                                i2 = 0;
                                sourceId = (String) pair.component1();
                                sourceName = (String) pair.component2();
                                try {
                                    streamUrl = c01751.$base$inlined + "/api/stream?mediaId=" + c01751.$tmdbId$inlined.intValue() + "&mediaType=" + c01751.$mediaType$inlined + "&tv_slug=" + c01751.$tvSlug$inlined + "&source=" + sourceId + "&apikey=mptv_sk_a8f29c4e7b3d1f&requestToken=" + c01751.$requestToken$inlined + "&token=" + c01751.$finalToken$inlined;
                                    Requests app = MainActivityKt.getApp();
                                    Map map = c01751.$headers$inlined;
                                    c01751.L$0 = $this$withPermit$iv2;
                                    c01751.L$1 = obj;
                                    c01751.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                                    c01751.L$3 = SpillingKt.nullOutSpilledVariable(sourceId);
                                    c01751.L$4 = sourceName;
                                    c01751.L$5 = SpillingKt.nullOutSpilledVariable(streamUrl);
                                    c01751.label = 2;
                                    obj3 = obj;
                                    $this$withPermit$iv3 = $this$withPermit$iv2;
                                    sourceId4 = sourceId;
                                    z = true;
                                    try {
                                        obj4 = Requests.get$default(app, streamUrl, map, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 10L, (Interceptor) null, false, (ResponseParser) null, this, 3836, (Object) null);
                                        c01751 = this;
                                        if (obj4 == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        sourceId5 = streamUrl;
                                        $this$withPermit$iv = $this$withPermit$iv3;
                                        sourceName2 = sourceName;
                                        obj2 = obj3;
                                        try {
                                            try {
                                                try {
                                                    NiceResponse this_$iv = (NiceResponse) obj4;
                                                    try {
                                                        ResponseParser parser = this_$iv.getParser();
                                                        Intrinsics.checkNotNull(parser);
                                                        safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(MappleStreamRes.class));
                                                    } catch (Exception e$iv) {
                                                        e$iv.printStackTrace();
                                                        safe = null;
                                                    }
                                                    streamRes = (MappleStreamRes) safe;
                                                    if (streamRes != null) {
                                                        zAreEqual = Intrinsics.areEqual(streamRes.getSuccess(), Boxing.boxBoolean(z));
                                                    } else {
                                                        zAreEqual = false;
                                                    }
                                                    if (zAreEqual) {
                                                        data = streamRes.getData();
                                                        if (data != null || (m3u8 = data.getStream_url()) == null) {
                                                            m3u8 = "";
                                                        }
                                                        if (m3u8.length() > 0) {
                                                            z2 = true;
                                                        } else {
                                                            z2 = false;
                                                        }
                                                        if (z2) {
                                                            if (!StringsKt.contains$default(m3u8, "omena-puu", false, 2, (Object) null) || StringsKt.contains$default(m3u8, "nocach", false, 2, (Object) null)) {
                                                                StringBuilder sbAppend = new StringBuilder().append(m3u8);
                                                                if (StringsKt.contains$default(m3u8, "?", false, 2, (Object) null)) {
                                                                    str = "&format=.m3u8";
                                                                } else {
                                                                    str = "?format=.m3u8";
                                                                }
                                                                m3u9 = sbAppend.append(str).toString();
                                                            } else {
                                                                m3u9 = m3u8;
                                                            }
                                                            M3u8Helper.Companion companion = M3u8Helper.Companion;
                                                            StringBuilder sbAppend2 = new StringBuilder().append("Mapple [");
                                                            String upperCase = sourceName2.toUpperCase(Locale.ROOT);
                                                            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                                                            String string = sbAppend2.append(upperCase).append(']').toString();
                                                            String str2 = c01751.$base$inlined + '/';
                                                            Map map2 = c01751.$headers$inlined;
                                                            c01751.L$0 = $this$withPermit$iv;
                                                            c01751.L$1 = obj2;
                                                            c01751.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                                                            c01751.L$3 = SpillingKt.nullOutSpilledVariable(sourceId4);
                                                            c01751.L$4 = SpillingKt.nullOutSpilledVariable(sourceName2);
                                                            c01751.L$5 = SpillingKt.nullOutSpilledVariable(sourceId5);
                                                            c01751.L$6 = SpillingKt.nullOutSpilledVariable(m3u9);
                                                            c01751.L$7 = SpillingKt.nullOutSpilledVariable(streamRes);
                                                            c01751.label = 3;
                                                            objGenerateM3u8$default = M3u8Helper.Companion.generateM3u8$default(companion, string, m3u9, str2, (Integer) null, map2, (String) null, c01751, 40, (Object) null);
                                                            if (objGenerateM3u8$default == coroutine_suspended) {
                                                                return coroutine_suspended;
                                                            }
                                                            sourceId2 = sourceName2;
                                                            $i$f$withPermit3 = $i$f$withPermit;
                                                            i3 = i;
                                                            $completion2 = $completion;
                                                            $i$f$withPermit2 = i2;
                                                            sourceId3 = sourceId4;
                                                            try {
                                                                $this$forEach$iv = (Iterable) objGenerateM3u8$default;
                                                                for (Object element$iv : $this$forEach$iv) {
                                                                    ExtractorLink it = (ExtractorLink) element$iv;
                                                                    Iterable $this$forEach$iv2 = $this$forEach$iv;
                                                                    int $i$f$withPermit4 = $i$f$withPermit3;
                                                                    try {
                                                                        c01751.$callback$inlined.invoke(it);
                                                                        c01751.$foundStreams$inlined.element = true;
                                                                        $this$forEach$iv = $this$forEach$iv2;
                                                                        $i$f$withPermit3 = $i$f$withPermit4;
                                                                    } catch (Exception e) {
                                                                        obj = obj2;
                                                                        unit = Unit.INSTANCE;
                                                                        $this$withPermit$iv.release();
                                                                        return unit;
                                                                    } catch (Throwable th) {
                                                                        th = th;
                                                                        $this$withPermit$iv.release();
                                                                        throw th;
                                                                    }
                                                                }
                                                                obj = obj2;
                                                            } catch (Exception e2) {
                                                            } catch (Throwable th2) {
                                                                th = th2;
                                                            }
                                                        }
                                                        unit = Unit.INSTANCE;
                                                        $this$withPermit$iv.release();
                                                        return unit;
                                                    }
                                                    obj = obj2;
                                                } catch (Exception e3) {
                                                    sourceId2 = sourceName2;
                                                    i3 = i;
                                                    $completion2 = $completion;
                                                    $i$f$withPermit2 = i2;
                                                    sourceId3 = sourceId4;
                                                    obj = obj2;
                                                    unit = Unit.INSTANCE;
                                                    $this$withPermit$iv.release();
                                                    return unit;
                                                }
                                                unit = Unit.INSTANCE;
                                                break;
                                            } catch (Exception e4) {
                                                e = e4;
                                                Log.INSTANCE.e("safeMap", "Request failed for " + obj + ' ' + e);
                                                unit = null;
                                            }
                                            $this$withPermit$iv.release();
                                            return unit;
                                        } catch (Throwable th3) {
                                            th = th3;
                                            $this$withPermit$iv.release();
                                            throw th;
                                        }
                                    } catch (Exception e5) {
                                        i3 = 0;
                                        $completion2 = $completion;
                                        $i$f$withPermit2 = 0;
                                        $this$withPermit$iv = $this$withPermit$iv3;
                                        sourceId2 = sourceName;
                                        sourceId3 = sourceId4;
                                        obj2 = obj3;
                                        obj = obj2;
                                        unit = Unit.INSTANCE;
                                        $this$withPermit$iv.release();
                                        return unit;
                                    } catch (Throwable th4) {
                                        th = th4;
                                        $this$withPermit$iv = $this$withPermit$iv3;
                                        $this$withPermit$iv.release();
                                        throw th;
                                    }
                                } catch (Exception e6) {
                                    Object obj5 = obj;
                                    i3 = 0;
                                    $completion2 = $completion;
                                    $i$f$withPermit2 = 0;
                                    $this$withPermit$iv = $this$withPermit$iv2;
                                    sourceId2 = sourceName;
                                    sourceId3 = sourceId;
                                    obj2 = obj5;
                                }
                            } catch (Exception e7) {
                                e = e7;
                                $this$withPermit$iv = $this$withPermit$iv2;
                                Log.INSTANCE.e("safeMap", "Request failed for " + obj + ' ' + e);
                                unit = null;
                                $this$withPermit$iv.release();
                                return unit;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            $this$withPermit$iv = $this$withPermit$iv2;
                        }
                        break;
                    case 1:
                        obj = c01751.L$1;
                        $this$withPermit$iv2 = (Semaphore) c01751.L$0;
                        ResultKt.throwOnFailure($result);
                        $i$f$withPermit = 0;
                        i = 0;
                        Pair pair2 = (Pair) obj;
                        $completion = (Continuation) c01751;
                        i2 = 0;
                        sourceId = (String) pair2.component1();
                        sourceName = (String) pair2.component2();
                        streamUrl = c01751.$base$inlined + "/api/stream?mediaId=" + c01751.$tmdbId$inlined.intValue() + "&mediaType=" + c01751.$mediaType$inlined + "&tv_slug=" + c01751.$tvSlug$inlined + "&source=" + sourceId + "&apikey=mptv_sk_a8f29c4e7b3d1f&requestToken=" + c01751.$requestToken$inlined + "&token=" + c01751.$finalToken$inlined;
                        Requests app2 = MainActivityKt.getApp();
                        Map map3 = c01751.$headers$inlined;
                        c01751.L$0 = $this$withPermit$iv2;
                        c01751.L$1 = obj;
                        c01751.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                        c01751.L$3 = SpillingKt.nullOutSpilledVariable(sourceId);
                        c01751.L$4 = sourceName;
                        c01751.L$5 = SpillingKt.nullOutSpilledVariable(streamUrl);
                        c01751.label = 2;
                        obj3 = obj;
                        $this$withPermit$iv3 = $this$withPermit$iv2;
                        sourceId4 = sourceId;
                        z = true;
                        obj4 = Requests.get$default(app2, streamUrl, map3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 10L, (Interceptor) null, false, (ResponseParser) null, this, 3836, (Object) null);
                        c01751 = this;
                        if (obj4 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        sourceId5 = streamUrl;
                        $this$withPermit$iv = $this$withPermit$iv3;
                        sourceName2 = sourceName;
                        obj2 = obj3;
                        NiceResponse this_$iv2 = (NiceResponse) obj4;
                        ResponseParser parser2 = this_$iv2.getParser();
                        Intrinsics.checkNotNull(parser2);
                        safe = parser2.parseSafe(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(MappleStreamRes.class));
                        streamRes = (MappleStreamRes) safe;
                        if (streamRes != null) {
                            zAreEqual = Intrinsics.areEqual(streamRes.getSuccess(), Boxing.boxBoolean(z));
                        } else {
                            zAreEqual = false;
                        }
                        if (zAreEqual) {
                            data = streamRes.getData();
                            if (data != null) {
                                m3u8 = "";
                            } else {
                                m3u8 = "";
                            }
                            if (m3u8.length() > 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (z2) {
                                if (StringsKt.contains$default(m3u8, "omena-puu", false, 2, (Object) null)) {
                                    StringBuilder sbAppend3 = new StringBuilder().append(m3u8);
                                    if (StringsKt.contains$default(m3u8, "?", false, 2, (Object) null)) {
                                        str = "&format=.m3u8";
                                    } else {
                                        str = "?format=.m3u8";
                                    }
                                    m3u9 = sbAppend3.append(str).toString();
                                } else {
                                    StringBuilder sbAppend4 = new StringBuilder().append(m3u8);
                                    if (StringsKt.contains$default(m3u8, "?", false, 2, (Object) null)) {
                                        str = "&format=.m3u8";
                                    } else {
                                        str = "?format=.m3u8";
                                    }
                                    m3u9 = sbAppend4.append(str).toString();
                                }
                                M3u8Helper.Companion companion2 = M3u8Helper.Companion;
                                StringBuilder sbAppend5 = new StringBuilder().append("Mapple [");
                                String upperCase2 = sourceName2.toUpperCase(Locale.ROOT);
                                Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
                                String string2 = sbAppend5.append(upperCase2).append(']').toString();
                                String str3 = c01751.$base$inlined + '/';
                                Map map4 = c01751.$headers$inlined;
                                c01751.L$0 = $this$withPermit$iv;
                                c01751.L$1 = obj2;
                                c01751.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                                c01751.L$3 = SpillingKt.nullOutSpilledVariable(sourceId4);
                                c01751.L$4 = SpillingKt.nullOutSpilledVariable(sourceName2);
                                c01751.L$5 = SpillingKt.nullOutSpilledVariable(sourceId5);
                                c01751.L$6 = SpillingKt.nullOutSpilledVariable(m3u9);
                                c01751.L$7 = SpillingKt.nullOutSpilledVariable(streamRes);
                                c01751.label = 3;
                                objGenerateM3u8$default = M3u8Helper.Companion.generateM3u8$default(companion2, string2, m3u9, str3, (Integer) null, map4, (String) null, c01751, 40, (Object) null);
                                if (objGenerateM3u8$default == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                sourceId2 = sourceName2;
                                $i$f$withPermit3 = $i$f$withPermit;
                                i3 = i;
                                $completion2 = $completion;
                                $i$f$withPermit2 = i2;
                                sourceId3 = sourceId4;
                                $this$forEach$iv = (Iterable) objGenerateM3u8$default;
                                while (r4.hasNext()) {
                                    ExtractorLink it2 = (ExtractorLink) element$iv;
                                    Iterable $this$forEach$iv3 = $this$forEach$iv;
                                    int $i$f$withPermit5 = $i$f$withPermit3;
                                    c01751.$callback$inlined.invoke(it2);
                                    c01751.$foundStreams$inlined.element = true;
                                    $this$forEach$iv = $this$forEach$iv3;
                                    $i$f$withPermit3 = $i$f$withPermit5;
                                }
                                obj = obj2;
                            }
                            unit = Unit.INSTANCE;
                            $this$withPermit$iv.release();
                            return unit;
                        }
                        obj = obj2;
                        unit = Unit.INSTANCE;
                        $this$withPermit$iv.release();
                        return unit;
                    case 2:
                        String streamUrl2 = (String) c01751.L$5;
                        sourceId2 = (String) c01751.L$4;
                        sourceId3 = (String) c01751.L$3;
                        $completion2 = (Continuation) c01751.L$2;
                        obj2 = c01751.L$1;
                        $this$withPermit$iv = (Semaphore) c01751.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            $i$f$withPermit = 0;
                            i = 0;
                            i2 = 0;
                            sourceId4 = sourceId3;
                            $completion = $completion2;
                            z = true;
                            sourceId5 = streamUrl2;
                            sourceName2 = sourceId2;
                            obj4 = $result;
                            NiceResponse this_$iv3 = (NiceResponse) obj4;
                            ResponseParser parser3 = this_$iv3.getParser();
                            Intrinsics.checkNotNull(parser3);
                            safe = parser3.parseSafe(this_$iv3.getText(), Reflection.getOrCreateKotlinClass(MappleStreamRes.class));
                            streamRes = (MappleStreamRes) safe;
                            if (streamRes != null) {
                                zAreEqual = Intrinsics.areEqual(streamRes.getSuccess(), Boxing.boxBoolean(z));
                            } else {
                                zAreEqual = false;
                            }
                            if (zAreEqual) {
                                data = streamRes.getData();
                                if (data != null) {
                                    m3u8 = "";
                                } else {
                                    m3u8 = "";
                                }
                                if (m3u8.length() > 0) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                if (z2) {
                                    if (StringsKt.contains$default(m3u8, "omena-puu", false, 2, (Object) null)) {
                                        StringBuilder sbAppend6 = new StringBuilder().append(m3u8);
                                        if (StringsKt.contains$default(m3u8, "?", false, 2, (Object) null)) {
                                            str = "&format=.m3u8";
                                        } else {
                                            str = "?format=.m3u8";
                                        }
                                        m3u9 = sbAppend6.append(str).toString();
                                    } else {
                                        StringBuilder sbAppend7 = new StringBuilder().append(m3u8);
                                        if (StringsKt.contains$default(m3u8, "?", false, 2, (Object) null)) {
                                            str = "&format=.m3u8";
                                        } else {
                                            str = "?format=.m3u8";
                                        }
                                        m3u9 = sbAppend7.append(str).toString();
                                    }
                                    M3u8Helper.Companion companion3 = M3u8Helper.Companion;
                                    StringBuilder sbAppend8 = new StringBuilder().append("Mapple [");
                                    String upperCase3 = sourceName2.toUpperCase(Locale.ROOT);
                                    Intrinsics.checkNotNullExpressionValue(upperCase3, "toUpperCase(...)");
                                    String string3 = sbAppend8.append(upperCase3).append(']').toString();
                                    String str4 = c01751.$base$inlined + '/';
                                    Map map5 = c01751.$headers$inlined;
                                    c01751.L$0 = $this$withPermit$iv;
                                    c01751.L$1 = obj2;
                                    c01751.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                                    c01751.L$3 = SpillingKt.nullOutSpilledVariable(sourceId4);
                                    c01751.L$4 = SpillingKt.nullOutSpilledVariable(sourceName2);
                                    c01751.L$5 = SpillingKt.nullOutSpilledVariable(sourceId5);
                                    c01751.L$6 = SpillingKt.nullOutSpilledVariable(m3u9);
                                    c01751.L$7 = SpillingKt.nullOutSpilledVariable(streamRes);
                                    c01751.label = 3;
                                    objGenerateM3u8$default = M3u8Helper.Companion.generateM3u8$default(companion3, string3, m3u9, str4, (Integer) null, map5, (String) null, c01751, 40, (Object) null);
                                    if (objGenerateM3u8$default == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    sourceId2 = sourceName2;
                                    $i$f$withPermit3 = $i$f$withPermit;
                                    i3 = i;
                                    $completion2 = $completion;
                                    $i$f$withPermit2 = i2;
                                    sourceId3 = sourceId4;
                                    $this$forEach$iv = (Iterable) objGenerateM3u8$default;
                                    while (r4.hasNext()) {
                                        ExtractorLink it3 = (ExtractorLink) element$iv;
                                        Iterable $this$forEach$iv4 = $this$forEach$iv;
                                        int $i$f$withPermit6 = $i$f$withPermit3;
                                        c01751.$callback$inlined.invoke(it3);
                                        c01751.$foundStreams$inlined.element = true;
                                        $this$forEach$iv = $this$forEach$iv4;
                                        $i$f$withPermit3 = $i$f$withPermit6;
                                    }
                                    obj = obj2;
                                }
                                unit = Unit.INSTANCE;
                                $this$withPermit$iv.release();
                                return unit;
                            }
                            obj = obj2;
                        } catch (Exception e8) {
                            i3 = 0;
                            $i$f$withPermit2 = 0;
                            obj = obj2;
                            unit = Unit.INSTANCE;
                            $this$withPermit$iv.release();
                            return unit;
                        } catch (Throwable th6) {
                            th = th6;
                            $this$withPermit$iv.release();
                            throw th;
                        }
                        unit = Unit.INSTANCE;
                        $this$withPermit$iv.release();
                        return unit;
                    case 3:
                        $i$f$withPermit3 = 0;
                        i3 = 0;
                        $i$f$withPermit2 = 0;
                        sourceId2 = (String) c01751.L$4;
                        sourceId3 = (String) c01751.L$3;
                        $completion2 = (Continuation) c01751.L$2;
                        obj2 = c01751.L$1;
                        $this$withPermit$iv = (Semaphore) c01751.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            objGenerateM3u8$default = $result;
                            $this$forEach$iv = (Iterable) objGenerateM3u8$default;
                            while (r4.hasNext()) {
                                ExtractorLink it4 = (ExtractorLink) element$iv;
                                Iterable $this$forEach$iv5 = $this$forEach$iv;
                                int $i$f$withPermit7 = $i$f$withPermit3;
                                c01751.$callback$inlined.invoke(it4);
                                c01751.$foundStreams$inlined.element = true;
                                $this$forEach$iv = $this$forEach$iv5;
                                $i$f$withPermit3 = $i$f$withPermit7;
                            }
                            obj = obj2;
                        } catch (Exception e9) {
                            obj = obj2;
                            unit = Unit.INSTANCE;
                            $this$withPermit$iv.release();
                            return unit;
                        }
                        unit = Unit.INSTANCE;
                        $this$withPermit$iv.release();
                        return unit;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Throwable th7) {
                th = th7;
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
                    CoroutineScope $this$coroutineScope2 = $this$coroutineScope;
                    Collection destination$iv$iv2 = destination$iv$iv;
                    $this$coroutineScope = $this$coroutineScope2;
                    destination$iv$iv2.add(BuildersKt.async$default($this$coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new C01751(semaphore, item$iv$iv, null, this.$base$inlined, this.$tmdbId$inlined, this.$mediaType$inlined, this.$tvSlug$inlined, this.$requestToken$inlined, this.$finalToken$inlined, this.$headers$inlined, this.$callback$inlined, this.$foundStreams$inlined), 2, (Object) null));
                    $this$map$iv = $this$map$iv;
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
