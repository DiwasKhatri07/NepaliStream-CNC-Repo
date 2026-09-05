package com.phisher98;

import com.lagradost.api.Log;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.ResponseParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
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
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;

/* JADX INFO: renamed from: com.phisher98.StreamPlayExtractor$invokeKickAssAnime$$inlined$safeAmap$default$1 */
/* JADX INFO: compiled from: StreamPlayUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeKickAssAnime$$inlined$safeAmap$default$1", f = "StreamPlayExtractor.kt", i = {0, 0}, l = {1898}, m = "invokeSuspend", n = {"$this$coroutineScope", "semaphore"}, nl = {-1}, s = {"L$0", "L$1"}, v = 2)
@SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2265:1\n1739#2:2266\n1814#2,3:2267\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n*L\n1887#1:2266\n1887#1:2267,3\n*E\n"})
public final class C0168xab72fdd0 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Object>>, Object> {
    final /* synthetic */ Function1 $callback$inlined;
    final /* synthetic */ int $concurrency;
    final /* synthetic */ Integer $episode$inlined;
    final /* synthetic */ Ref.ObjectRef $slug$inlined;
    final /* synthetic */ Function1 $subtitleCallback$inlined;
    final /* synthetic */ Iterable $this_runCatching;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0168xab72fdd0(int i, Iterable iterable, Continuation continuation, Ref.ObjectRef objectRef, Integer num, Function1 function1, Function1 function2) {
        super(2, continuation);
        this.$concurrency = i;
        this.$this_runCatching = iterable;
        this.$slug$inlined = objectRef;
        this.$episode$inlined = num;
        this.$callback$inlined = function1;
        this.$subtitleCallback$inlined = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> c0168xab72fdd0 = new C0168xab72fdd0(this.$concurrency, this.$this_runCatching, continuation, this.$slug$inlined, this.$episode$inlined, this.$callback$inlined, this.$subtitleCallback$inlined);
        c0168xab72fdd0.L$0 = obj;
        return c0168xab72fdd0;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Object>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayExtractor$invokeKickAssAnime$$inlined$safeAmap$default$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "B", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeKickAssAnime$$inlined$safeAmap$default$1$1", f = "StreamPlayExtractor.kt", i = {0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {2266, 2269, 2285, 2296}, m = "invokeSuspend", n = {"$this$withPermit$iv", "$this$withPermit$iv", "$completion", "locale", "$this$withPermit$iv", "$completion", "locale", "json", "jsonresponse", "href", "matchedSlug", "$this$withPermit$iv", "$completion", "locale", "json", "jsonresponse", "servers", "$this$safeAmap_u24default$iv", "$completion$iv", "href", "matchedSlug", "$this$safeAmap_u24lambda_u240$iv", "concurrency$iv"}, nl = {2267, 2272, 2286, 2297}, s = {"L$0", "L$0", "L$2", "L$3", "L$0", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "I$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreKt\n+ 3 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 6 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt\n*L\n1#1,2265:1\n81#2,3:2266\n85#2,2:2300\n1549#3,8:2269\n1557#3,3:2278\n1560#3,4:2282\n1565#3:2291\n1716#3:2299\n296#4:2277\n297#4:2281\n73#5,5:2286\n1880#6,5:2292\n1899#6,2:2297\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n*L\n1889#1:2266,3\n1889#1:2300,2\n1556#2:2277\n1556#2:2281\n1563#2:2286,5\n1565#2:2292,5\n1565#2:2297,2\n*E\n"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {
        final /* synthetic */ Function1 $callback$inlined;
        final /* synthetic */ Integer $episode$inlined;
        final /* synthetic */ Object $item;
        final /* synthetic */ Semaphore $semaphore;
        final /* synthetic */ Ref.ObjectRef $slug$inlined;
        final /* synthetic */ Function1 $subtitleCallback$inlined;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Semaphore semaphore, Object obj, Continuation continuation, Ref.ObjectRef objectRef, Integer num, Function1 function1, Function1 function2) {
            super(2, continuation);
            this.$semaphore = semaphore;
            this.$item = obj;
            this.$slug$inlined = objectRef;
            this.$episode$inlined = num;
            this.$callback$inlined = function1;
            this.$subtitleCallback$inlined = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$semaphore, this.$item, continuation, this.$slug$inlined, this.$episode$inlined, this.$callback$inlined, this.$subtitleCallback$inlined);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Object> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:104:0x0374 A[ADDED_TO_REGION, REMOVE] */
        /* JADX WARN: Code duplicated, block: B:130:0x0186 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:153:0x01b1 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:33:0x0168 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:48:0x01b8 A[Catch: Exception -> 0x037d, all -> 0x0380, TryCatch #0 {all -> 0x0380, blocks: (B:34:0x0169, B:35:0x0180, B:37:0x0186, B:39:0x0199, B:46:0x01b3, B:48:0x01b8, B:50:0x01be, B:52:0x0222, B:105:0x0376, B:31:0x010d), top: B:123:0x010d }] */
        public final Object invokeSuspend(Object $result) throws Throwable {
            Semaphore $this$withPermit$iv;
            int $i$f$withPermit;
            Object obj;
            int i;
            Semaphore $this$withPermit$iv2;
            Continuation $completion;
            int i2;
            String locale;
            Object objSafeGet$default;
            Unit unit;
            Object obj2;
            int i3;
            Iterator it;
            Unit unit2;
            Object element$iv;
            EpisoderesponseKAA episoderesponseKAA;
            Unit unit3;
            String matchedSlug;
            Object objSafeGet$default2;
            String href;
            String locale2;
            String json;
            List jsonresponse;
            EpisoderesponseKAA it2;
            Object safe;
            ServersResKAA serversResKAA;
            Iterable servers;
            Semaphore $this$withPermit$iv3;
            Object objCoroutineScope;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Semaphore $this$withPermit$iv4 = this.$semaphore;
                    Object obj3 = this.$item;
                    this.L$0 = $this$withPermit$iv4;
                    this.L$1 = obj3;
                    this.label = 1;
                    if ($this$withPermit$iv4.acquire((Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $this$withPermit$iv = $this$withPermit$iv4;
                    $i$f$withPermit = 0;
                    obj = obj3;
                    i = 0;
                    try {
                        try {
                            String locale3 = (String) obj;
                            $completion = (Continuation) this;
                            i2 = 0;
                            String str = "https://kaa.lt/api/show/" + ((String) this.$slug$inlined.element) + "/episodes?ep=1&lang=" + locale3;
                            Long lBoxLong = Boxing.boxLong(5000L);
                            this.L$0 = $this$withPermit$iv;
                            this.L$1 = obj;
                            this.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(locale3);
                            this.label = 2;
                            locale = locale3;
                            objSafeGet$default = StreamPlayUtilsKt.safeGet$default(str, null, null, lBoxLong, null, false, 0, this, 118, null);
                            if (objSafeGet$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            String json2 = ((NiceResponse) objSafeGet$default).toString();
                            List jsonToEpisodes = StreamPlayUtilsKt.parseJsonToEpisodes(json2);
                            List $this$firstOrNull$iv = jsonToEpisodes;
                            it = $this$firstOrNull$iv.iterator();
                            try {
                                do {
                                    if (it.hasNext()) {
                                        try {
                                            element$iv = it.next();
                                            it2 = (EpisoderesponseKAA) element$iv;
                                            unit2 = null;
                                            try {
                                            } catch (Exception e) {
                                                e = e;
                                                unit = unit2;
                                                obj2 = obj;
                                                $this$withPermit$iv2 = $this$withPermit$iv;
                                                i3 = i;
                                                Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                                                $this$withPermit$iv = $this$withPermit$iv2;
                                                unit3 = unit;
                                                $this$withPermit$iv.release();
                                                return unit3;
                                            }
                                        } catch (Exception e2) {
                                            e = e2;
                                            unit2 = null;
                                            unit = unit2;
                                            obj2 = obj;
                                            $this$withPermit$iv2 = $this$withPermit$iv;
                                            i3 = i;
                                            Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                                            $this$withPermit$iv = $this$withPermit$iv2;
                                            unit3 = unit;
                                            $this$withPermit$iv.release();
                                            return unit3;
                                        }
                                    } else {
                                        unit2 = null;
                                        element$iv = null;
                                    }
                                    episoderesponseKAA = (EpisoderesponseKAA) element$iv;
                                    if (episoderesponseKAA != null || (matchedSlug = episoderesponseKAA.getSlug()) == null) {
                                        unit3 = Unit.INSTANCE;
                                        $this$withPermit$iv.release();
                                        return unit3;
                                    }
                                    String href2 = "https://kaa.lt/api/show/" + ((String) this.$slug$inlined.element) + "/episode/ep-" + this.$episode$inlined + '-' + matchedSlug;
                                    this.L$0 = $this$withPermit$iv;
                                    this.L$1 = obj;
                                    this.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                                    this.L$3 = SpillingKt.nullOutSpilledVariable(locale);
                                    this.L$4 = SpillingKt.nullOutSpilledVariable(json2);
                                    this.L$5 = SpillingKt.nullOutSpilledVariable(jsonToEpisodes);
                                    this.L$6 = SpillingKt.nullOutSpilledVariable(href2);
                                    this.L$7 = SpillingKt.nullOutSpilledVariable(matchedSlug);
                                    this.label = 3;
                                    unit = unit2;
                                    objSafeGet$default2 = StreamPlayUtilsKt.safeGet$default(href2, null, null, null, null, false, 0, this, 126, null);
                                    if (objSafeGet$default2 == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    href = href2;
                                    locale2 = matchedSlug;
                                    $this$withPermit$iv2 = $this$withPermit$iv;
                                    i3 = i;
                                    json = json2;
                                    jsonresponse = jsonToEpisodes;
                                    try {
                                        try {
                                            NiceResponse this_$iv = (NiceResponse) objSafeGet$default2;
                                            try {
                                                ResponseParser parser = this_$iv.getParser();
                                                Intrinsics.checkNotNull(parser);
                                                safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(ServersResKAA.class));
                                            } catch (Exception e$iv) {
                                                e$iv.printStackTrace();
                                                safe = unit;
                                            }
                                            serversResKAA = (ServersResKAA) safe;
                                            if (serversResKAA != null || (servers = serversResKAA.getServers()) == null) {
                                                try {
                                                    $this$withPermit$iv = $this$withPermit$iv2;
                                                    unit3 = Unit.INSTANCE;
                                                } catch (Exception e3) {
                                                    e = e3;
                                                    obj2 = obj;
                                                    i3 = i3;
                                                    Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                                                    $this$withPermit$iv = $this$withPermit$iv2;
                                                    unit3 = unit;
                                                }
                                                $this$withPermit$iv.release();
                                                return unit3;
                                            }
                                            Iterable $this$safeAmap_u24default$iv = servers;
                                            try {
                                                Result.Companion companion = Result.Companion;
                                                try {
                                                    C0170xa086f69d c0170xa086f69d = new C0170xa086f69d(7, $this$safeAmap_u24default$iv, null, this.$callback$inlined, this.$subtitleCallback$inlined);
                                                    this.L$0 = $this$withPermit$iv2;
                                                    this.L$1 = obj;
                                                    int i4 = i3;
                                                    try {
                                                        this.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                                                        this.L$3 = SpillingKt.nullOutSpilledVariable(locale);
                                                        this.L$4 = SpillingKt.nullOutSpilledVariable(json);
                                                        this.L$5 = SpillingKt.nullOutSpilledVariable(jsonresponse);
                                                        this.L$6 = SpillingKt.nullOutSpilledVariable(servers);
                                                        this.L$7 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv);
                                                        this.L$8 = SpillingKt.nullOutSpilledVariable(this);
                                                        this.L$9 = SpillingKt.nullOutSpilledVariable(href);
                                                        this.L$10 = SpillingKt.nullOutSpilledVariable(locale2);
                                                        this.L$11 = SpillingKt.nullOutSpilledVariable($this$safeAmap_u24default$iv);
                                                        this.I$0 = 7;
                                                        this.label = 4;
                                                        objCoroutineScope = CoroutineScopeKt.coroutineScope(c0170xa086f69d, this);
                                                        if (objCoroutineScope == coroutine_suspended) {
                                                            return coroutine_suspended;
                                                        }
                                                        $this$withPermit$iv3 = $this$withPermit$iv2;
                                                        i3 = i4;
                                                        try {
                                                            Result.constructor-impl((List) objCoroutineScope);
                                                            break;
                                                        } catch (Throwable th) {
                                                            th = th;
                                                            try {
                                                                Result.Companion companion2 = Result.Companion;
                                                                Result.constructor-impl(ResultKt.createFailure(th));
                                                            } catch (Exception e4) {
                                                                e = e4;
                                                                obj2 = obj;
                                                                $this$withPermit$iv2 = $this$withPermit$iv3;
                                                                Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                                                                $this$withPermit$iv = $this$withPermit$iv2;
                                                                unit3 = unit;
                                                            } catch (Throwable th2) {
                                                                th = th2;
                                                                $this$withPermit$iv2 = $this$withPermit$iv3;
                                                                $this$withPermit$iv2.release();
                                                                throw th;
                                                            }
                                                        }
                                                        unit3 = Unit.INSTANCE;
                                                        $this$withPermit$iv = $this$withPermit$iv3;
                                                        $this$withPermit$iv.release();
                                                        return unit3;
                                                    } catch (Throwable th3) {
                                                        th = th3;
                                                        $this$withPermit$iv3 = $this$withPermit$iv2;
                                                        i3 = i4;
                                                        Result.Companion companion3 = Result.Companion;
                                                        Result.constructor-impl(ResultKt.createFailure(th));
                                                        unit3 = Unit.INSTANCE;
                                                        $this$withPermit$iv = $this$withPermit$iv3;
                                                        $this$withPermit$iv.release();
                                                        return unit3;
                                                    }
                                                } catch (Throwable th4) {
                                                    th = th4;
                                                    $this$withPermit$iv3 = $this$withPermit$iv2;
                                                    i3 = i3;
                                                }
                                            } catch (Throwable th5) {
                                                th = th5;
                                                $this$withPermit$iv3 = $this$withPermit$iv2;
                                                i3 = i3;
                                            }
                                            break;
                                        } catch (Exception e5) {
                                            e = e5;
                                            obj2 = obj;
                                        }
                                        $this$withPermit$iv.release();
                                        return unit3;
                                    } catch (Throwable th6) {
                                        th = th6;
                                        $this$withPermit$iv2.release();
                                        throw th;
                                    }
                                    Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                                    $this$withPermit$iv = $this$withPermit$iv2;
                                    unit3 = unit;
                                } while (!Intrinsics.areEqual(StringsKt.toIntOrNull(StringsKt.substringBefore$default(it2.getEpisode_number().toString(), ".", (String) null, 2, (Object) null)), this.$episode$inlined));
                                if (episoderesponseKAA != null) {
                                }
                                unit3 = Unit.INSTANCE;
                            } catch (Exception e6) {
                                e = e6;
                                obj2 = obj;
                                $this$withPermit$iv2 = $this$withPermit$iv;
                                i3 = i;
                            }
                            episoderesponseKAA = (EpisoderesponseKAA) element$iv;
                        } catch (Throwable th7) {
                            th = th7;
                            $this$withPermit$iv2 = $this$withPermit$iv;
                            $this$withPermit$iv2.release();
                            throw th;
                        }
                    } catch (Exception e7) {
                        e = e7;
                        unit = null;
                        obj2 = obj;
                        $this$withPermit$iv2 = $this$withPermit$iv;
                        i3 = i;
                        Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                        $this$withPermit$iv = $this$withPermit$iv2;
                        unit3 = unit;
                        $this$withPermit$iv.release();
                        return unit3;
                    }
                    $this$withPermit$iv.release();
                    return unit3;
                case 1:
                    Object obj4 = this.L$1;
                    Semaphore $this$withPermit$iv5 = (Semaphore) this.L$0;
                    ResultKt.throwOnFailure($result);
                    $i$f$withPermit = 0;
                    $this$withPermit$iv = $this$withPermit$iv5;
                    obj = obj4;
                    i = 0;
                    String locale4 = (String) obj;
                    $completion = (Continuation) this;
                    i2 = 0;
                    String str2 = "https://kaa.lt/api/show/" + ((String) this.$slug$inlined.element) + "/episodes?ep=1&lang=" + locale4;
                    Long lBoxLong2 = Boxing.boxLong(5000L);
                    this.L$0 = $this$withPermit$iv;
                    this.L$1 = obj;
                    this.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(locale4);
                    this.label = 2;
                    locale = locale4;
                    objSafeGet$default = StreamPlayUtilsKt.safeGet$default(str2, null, null, lBoxLong2, null, false, 0, this, 118, null);
                    if (objSafeGet$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    String json3 = ((NiceResponse) objSafeGet$default).toString();
                    List jsonToEpisodes2 = StreamPlayUtilsKt.parseJsonToEpisodes(json3);
                    List $this$firstOrNull$iv2 = jsonToEpisodes2;
                    it = $this$firstOrNull$iv2.iterator();
                    do {
                        if (it.hasNext()) {
                            element$iv = it.next();
                            it2 = (EpisoderesponseKAA) element$iv;
                            unit2 = null;
                        } else {
                            unit2 = null;
                            element$iv = null;
                        }
                        episoderesponseKAA = (EpisoderesponseKAA) element$iv;
                        if (episoderesponseKAA != null) {
                        }
                        unit3 = Unit.INSTANCE;
                        $this$withPermit$iv.release();
                        return unit3;
                    } while (!Intrinsics.areEqual(StringsKt.toIntOrNull(StringsKt.substringBefore$default(it2.getEpisode_number().toString(), ".", (String) null, 2, (Object) null)), this.$episode$inlined));
                    episoderesponseKAA = (EpisoderesponseKAA) element$iv;
                    if (episoderesponseKAA != null) {
                    }
                    unit3 = Unit.INSTANCE;
                    $this$withPermit$iv.release();
                    return unit3;
                case 2:
                    i3 = 0;
                    String locale5 = (String) this.L$3;
                    Continuation $completion2 = (Continuation) this.L$2;
                    Object obj5 = this.L$1;
                    Semaphore $this$withPermit$iv6 = (Semaphore) this.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        i2 = 0;
                        $i$f$withPermit = 0;
                        i = 0;
                        locale = locale5;
                        $completion = $completion2;
                        obj = obj5;
                        $this$withPermit$iv = $this$withPermit$iv6;
                        objSafeGet$default = $result;
                        String json4 = ((NiceResponse) objSafeGet$default).toString();
                        List jsonToEpisodes3 = StreamPlayUtilsKt.parseJsonToEpisodes(json4);
                        List $this$firstOrNull$iv3 = jsonToEpisodes3;
                        it = $this$firstOrNull$iv3.iterator();
                        do {
                            if (it.hasNext()) {
                                element$iv = it.next();
                                it2 = (EpisoderesponseKAA) element$iv;
                                unit2 = null;
                            } else {
                                unit2 = null;
                                element$iv = null;
                            }
                            episoderesponseKAA = (EpisoderesponseKAA) element$iv;
                            if (episoderesponseKAA != null) {
                            }
                            unit3 = Unit.INSTANCE;
                            $this$withPermit$iv.release();
                            return unit3;
                        } while (!Intrinsics.areEqual(StringsKt.toIntOrNull(StringsKt.substringBefore$default(it2.getEpisode_number().toString(), ".", (String) null, 2, (Object) null)), this.$episode$inlined));
                        episoderesponseKAA = (EpisoderesponseKAA) element$iv;
                        if (episoderesponseKAA != null) {
                        }
                        unit3 = Unit.INSTANCE;
                    } catch (Exception e8) {
                        e = e8;
                        obj2 = obj5;
                        $this$withPermit$iv2 = $this$withPermit$iv6;
                        unit = null;
                        break;
                    } catch (Throwable th8) {
                        th = th8;
                        $this$withPermit$iv2 = $this$withPermit$iv6;
                        $this$withPermit$iv2.release();
                        throw th;
                    }
                    $this$withPermit$iv.release();
                    return unit3;
                case 3:
                    i3 = 0;
                    String matchedSlug2 = (String) this.L$7;
                    String href3 = (String) this.L$6;
                    jsonresponse = (List) this.L$5;
                    String json5 = (String) this.L$4;
                    String locale6 = (String) this.L$3;
                    Continuation $completion3 = (Continuation) this.L$2;
                    obj2 = this.L$1;
                    $this$withPermit$iv2 = (Semaphore) this.L$0;
                    try {
                        try {
                            ResultKt.throwOnFailure($result);
                            $i$f$withPermit = 0;
                            json = json5;
                            locale = locale6;
                            $completion = $completion3;
                            obj = obj2;
                            unit = null;
                            objSafeGet$default2 = $result;
                            locale2 = matchedSlug2;
                            href = href3;
                            NiceResponse this_$iv2 = (NiceResponse) objSafeGet$default2;
                            ResponseParser parser2 = this_$iv2.getParser();
                            Intrinsics.checkNotNull(parser2);
                            safe = parser2.parseSafe(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(ServersResKAA.class));
                            serversResKAA = (ServersResKAA) safe;
                            if (serversResKAA != null) {
                            }
                            $this$withPermit$iv = $this$withPermit$iv2;
                            unit3 = Unit.INSTANCE;
                        } catch (Exception e9) {
                            e = e9;
                            unit = null;
                            break;
                        }
                        $this$withPermit$iv.release();
                        return unit3;
                    } catch (Throwable th9) {
                        th = th9;
                        $this$withPermit$iv2.release();
                        throw th;
                    }
                case 4:
                    i3 = 0;
                    int i5 = this.I$0;
                    Object obj6 = this.L$1;
                    $this$withPermit$iv3 = (Semaphore) this.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        obj = obj6;
                        objCoroutineScope = $result;
                        unit = null;
                        Result.constructor-impl((List) objCoroutineScope);
                        break;
                    } catch (Throwable th10) {
                        th = th10;
                        obj = obj6;
                        unit = null;
                        Result.Companion companion4 = Result.Companion;
                        Result.constructor-impl(ResultKt.createFailure(th));
                        unit3 = Unit.INSTANCE;
                        $this$withPermit$iv = $this$withPermit$iv3;
                        $this$withPermit$iv.release();
                        return unit3;
                    }
                    unit3 = Unit.INSTANCE;
                    $this$withPermit$iv = $this$withPermit$iv3;
                    $this$withPermit$iv.release();
                    return unit3;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
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
                    destination$iv$iv2.add(BuildersKt.async$default($this$coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new AnonymousClass1(semaphore, item$iv$iv, null, this.$slug$inlined, this.$episode$inlined, this.$callback$inlined, this.$subtitleCallback$inlined), 2, (Object) null));
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
