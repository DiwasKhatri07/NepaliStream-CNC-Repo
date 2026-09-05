package com.phisher98;

import com.lagradost.api.Log;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
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
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
import okhttp3.Interceptor;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: renamed from: com.phisher98.StreamPlayExtractor$invokeZinkmovies$lambda$2$$inlined$safeAmap$default$1 */
/* JADX INFO: compiled from: StreamPlayUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeZinkmovies$lambda$2$$inlined$safeAmap$default$1", f = "StreamPlayExtractor.kt", i = {0, 0}, l = {1898}, m = "invokeSuspend", n = {"$this$coroutineScope", "semaphore"}, nl = {-1}, s = {"L$0", "L$1"}, v = 2)
@SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2265:1\n1739#2:2266\n1814#2,3:2267\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n*L\n1887#1:2266\n1887#1:2267,3\n*E\n"})
public final class C0240x4a5f1dc9 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Unit>>, Object> {
    final /* synthetic */ Function1 $callback$inlined;
    final /* synthetic */ int $concurrency;
    final /* synthetic */ Integer $episode$inlined;
    final /* synthetic */ Function1 $subtitleCallback$inlined;
    final /* synthetic */ Iterable $this_runCatching;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0240x4a5f1dc9(int i, Iterable iterable, Continuation continuation, Function1 function1, Function1 function2, Integer num) {
        super(2, continuation);
        this.$concurrency = i;
        this.$this_runCatching = iterable;
        this.$subtitleCallback$inlined = function1;
        this.$callback$inlined = function2;
        this.$episode$inlined = num;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> c0240x4a5f1dc9 = new C0240x4a5f1dc9(this.$concurrency, this.$this_runCatching, continuation, this.$subtitleCallback$inlined, this.$callback$inlined, this.$episode$inlined);
        c0240x4a5f1dc9.L$0 = obj;
        return c0240x4a5f1dc9;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Unit>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayExtractor$invokeZinkmovies$lambda$2$$inlined$safeAmap$default$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "B", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeZinkmovies$lambda$2$$inlined$safeAmap$default$1$1", f = "StreamPlayExtractor.kt", i = {0, 1, 1, 1, 2, 2, 2, 2, 2}, l = {2266, 2269, 2278}, m = "invokeSuspend", n = {"$this$withPermit$iv", "$this$withPermit$iv", "$completion", "seasonBtnUrl", "$this$withPermit$iv", "$completion", "seasonBtnUrl", "episodeDoc", "episodeUrl"}, nl = {2267, 2270, 2279}, s = {"L$0", "L$0", "L$2", "L$3", "L$0", "L$2", "L$3", "L$4", "L$5"}, v = 2)
    @SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreKt\n+ 3 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2265:1\n81#2,3:2266\n85#2,2:2280\n5475#3,3:2269\n5479#3:2273\n5478#3:2274\n5480#3,4:2276\n296#4:2272\n297#4:2275\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n*L\n1889#1:2266,3\n1889#1:2280,2\n5477#2:2272\n5477#2:2275\n*E\n"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1 $callback$inlined;
        final /* synthetic */ Integer $episode$inlined;
        final /* synthetic */ Object $item;
        final /* synthetic */ Semaphore $semaphore;
        final /* synthetic */ Function1 $subtitleCallback$inlined;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Semaphore semaphore, Object obj, Continuation continuation, Function1 function1, Function1 function2, Integer num) {
            super(2, continuation);
            this.$semaphore = semaphore;
            this.$item = obj;
            this.$subtitleCallback$inlined = function1;
            this.$callback$inlined = function2;
            this.$episode$inlined = num;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$semaphore, this.$item, continuation, this.$subtitleCallback$inlined, this.$callback$inlined, this.$episode$inlined);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:109:0x017d A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:110:0x0173 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:31:0x00ff A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:32:0x0100  */
        /* JADX WARN: Code duplicated, block: B:36:0x0122 A[Catch: all -> 0x01cc, Exception -> 0x01d1, TRY_LEAVE, TryCatch #9 {all -> 0x01cc, blocks: (B:33:0x0107, B:34:0x011c, B:36:0x0122, B:37:0x012f, B:39:0x0141, B:41:0x0148, B:43:0x014f, B:45:0x0159, B:48:0x0166, B:60:0x0183, B:62:0x0188, B:64:0x0190, B:69:0x01c5), top: B:97:0x0107 }] */
        /* JADX WARN: Code duplicated, block: B:41:0x0148 A[Catch: Exception -> 0x01ca, all -> 0x01cc, TryCatch #4 {Exception -> 0x01ca, blocks: (B:39:0x0141, B:41:0x0148, B:43:0x014f, B:45:0x0159, B:48:0x0166, B:60:0x0183, B:62:0x0188, B:64:0x0190, B:69:0x01c5), top: B:94:0x0141 }] */
        /* JADX WARN: Code duplicated, block: B:51:0x016e  */
        /* JADX WARN: Code duplicated, block: B:56:0x0174 A[LOOP:0: B:34:0x011c->B:56:0x0174, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:62:0x0188 A[Catch: Exception -> 0x01ca, all -> 0x01cc, TryCatch #4 {Exception -> 0x01ca, blocks: (B:39:0x0141, B:41:0x0148, B:43:0x014f, B:45:0x0159, B:48:0x0166, B:60:0x0183, B:62:0x0188, B:64:0x0190, B:69:0x01c5), top: B:94:0x0141 }] */
        public final Object invokeSuspend(Object $result) throws Throwable {
            Semaphore $this$withPermit$iv;
            Object obj;
            int $i$f$withPermit;
            Semaphore $this$withPermit$iv2;
            int $i$f$withPermit2;
            Object obj2;
            Continuation $completion;
            String seasonBtnUrl;
            int i;
            Semaphore $this$withPermit$iv3;
            Object obj3;
            Object obj4;
            Object obj5;
            AnonymousClass1 anonymousClass1;
            String seasonBtnUrl2;
            Continuation $completion2;
            Iterable $this$firstOrNull$iv;
            int $i$f$firstOrNull;
            Iterator it;
            Object element$iv;
            Element element;
            String episodeUrl;
            Object zinkLinks;
            boolean z;
            Iterable $this$firstOrNull$iv2;
            int $i$f$firstOrNull2;
            MatchResult matchResultFind$default;
            List groupValues;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            Object obj6 = null;
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Semaphore $this$withPermit$iv4 = this.$semaphore;
                    Object obj7 = this.$item;
                    this.L$0 = $this$withPermit$iv4;
                    this.L$1 = obj7;
                    this.label = 1;
                    if ($this$withPermit$iv4.acquire((Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $this$withPermit$iv = $this$withPermit$iv4;
                    obj = obj7;
                    $i$f$withPermit = 0;
                    try {
                        $completion = (Continuation) this;
                        seasonBtnUrl = (String) obj;
                        i = 0;
                        Requests app = MainActivityKt.getApp();
                        this.L$0 = $this$withPermit$iv;
                        this.L$1 = obj;
                        this.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(seasonBtnUrl);
                        this.label = 2;
                        $this$withPermit$iv3 = $this$withPermit$iv;
                        obj3 = obj;
                        obj4 = null;
                        try {
                            obj5 = Requests.get$default(app, seasonBtnUrl, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, this, 4094, (Object) null);
                            anonymousClass1 = this;
                            if (obj5 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            seasonBtnUrl2 = seasonBtnUrl;
                            $completion2 = $completion;
                            obj2 = obj3;
                            $this$withPermit$iv2 = $this$withPermit$iv3;
                            try {
                                try {
                                    Document episodeDoc = ((NiceResponse) obj5).getDocument();
                                    $this$firstOrNull$iv = episodeDoc.select("a.maxbutton-download-now");
                                    $i$f$firstOrNull = 0;
                                    it = $this$firstOrNull$iv.iterator();
                                    while (true) {
                                        if (it.hasNext()) {
                                            element$iv = it.next();
                                            Element a = (Element) element$iv;
                                            try {
                                                z = false;
                                                $this$firstOrNull$iv2 = $this$firstOrNull$iv;
                                                $i$f$firstOrNull2 = $i$f$firstOrNull;
                                                obj6 = null;
                                                try {
                                                    matchResultFind$default = Regex.find$default(new Regex("EPISODE\\s*-\\s*0*(\\d+)", RegexOption.IGNORE_CASE), a.text(), 0, 2, (Object) null);
                                                    if (matchResultFind$default == null && (groupValues = matchResultFind$default.getGroupValues()) != null) {
                                                        String str = (String) groupValues.get(1);
                                                        if (str != null) {
                                                            Integer intOrNull = StringsKt.toIntOrNull(str);
                                                            int iIntValue = anonymousClass1.$episode$inlined.intValue();
                                                            if (intOrNull != null && intOrNull.intValue() == iIntValue) {
                                                                z = true;
                                                            }
                                                        }
                                                    }
                                                    if (!z) {
                                                        obj4 = null;
                                                        $i$f$firstOrNull = $i$f$firstOrNull2;
                                                        $this$firstOrNull$iv = $this$firstOrNull$iv2;
                                                    }
                                                } catch (Exception e) {
                                                    e = e;
                                                    $i$f$withPermit2 = $i$f$withPermit;
                                                    try {
                                                        Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                                                    } catch (Throwable th) {
                                                        th = th;
                                                        $this$withPermit$iv2.release();
                                                        throw th;
                                                    }
                                                }
                                            } catch (Exception e2) {
                                                e = e2;
                                                obj6 = null;
                                            }
                                        } else {
                                            element$iv = obj4;
                                        }
                                    }
                                    element = (Element) element$iv;
                                    if (element != null || (episodeUrl = element.attr("href")) == null) {
                                        obj6 = Unit.INSTANCE;
                                    } else {
                                        StreamPlayExtractor streamPlayExtractor = StreamPlayExtractor.INSTANCE;
                                        Function1<? super SubtitleFile, Unit> function1 = anonymousClass1.$subtitleCallback$inlined;
                                        Function1<? super ExtractorLink, Unit> function2 = anonymousClass1.$callback$inlined;
                                        anonymousClass1.L$0 = $this$withPermit$iv2;
                                        anonymousClass1.L$1 = obj2;
                                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable($completion2);
                                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(seasonBtnUrl2);
                                        anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(episodeDoc);
                                        anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(episodeUrl);
                                        anonymousClass1.label = 3;
                                        zinkLinks = streamPlayExtractor.getZinkLinks(episodeUrl, function1, function2, anonymousClass1);
                                        if (zinkLinks == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        $i$f$withPermit2 = $i$f$withPermit;
                                        obj6 = zinkLinks;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    $this$withPermit$iv2.release();
                                    throw th;
                                }
                            } catch (Exception e3) {
                                e = e3;
                                obj6 = obj4;
                            }
                            $this$withPermit$iv2.release();
                            return obj6;
                        } catch (Exception e4) {
                            e = e4;
                            obj6 = null;
                            $i$f$withPermit2 = $i$f$withPermit;
                            obj2 = obj3;
                            $this$withPermit$iv2 = $this$withPermit$iv3;
                            Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                            $this$withPermit$iv2.release();
                            return obj6;
                        } catch (Throwable th3) {
                            th = th3;
                            $this$withPermit$iv2 = $this$withPermit$iv3;
                            $this$withPermit$iv2.release();
                            throw th;
                        }
                    } catch (Exception e5) {
                        e = e5;
                        Object obj8 = obj;
                        $i$f$withPermit2 = $i$f$withPermit;
                        obj2 = obj8;
                        $this$withPermit$iv2 = $this$withPermit$iv;
                    } catch (Throwable th4) {
                        th = th4;
                        $this$withPermit$iv2 = $this$withPermit$iv;
                    }
                    break;
                case 1:
                    Object obj9 = this.L$1;
                    Semaphore $this$withPermit$iv5 = (Semaphore) this.L$0;
                    ResultKt.throwOnFailure($result);
                    $i$f$withPermit = 0;
                    obj = obj9;
                    $this$withPermit$iv = $this$withPermit$iv5;
                    $completion = (Continuation) this;
                    seasonBtnUrl = (String) obj;
                    i = 0;
                    Requests app2 = MainActivityKt.getApp();
                    this.L$0 = $this$withPermit$iv;
                    this.L$1 = obj;
                    this.L$2 = SpillingKt.nullOutSpilledVariable($completion);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(seasonBtnUrl);
                    this.label = 2;
                    $this$withPermit$iv3 = $this$withPermit$iv;
                    obj3 = obj;
                    obj4 = null;
                    obj5 = Requests.get$default(app2, seasonBtnUrl, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, this, 4094, (Object) null);
                    anonymousClass1 = this;
                    if (obj5 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    seasonBtnUrl2 = seasonBtnUrl;
                    $completion2 = $completion;
                    obj2 = obj3;
                    $this$withPermit$iv2 = $this$withPermit$iv3;
                    Document episodeDoc2 = ((NiceResponse) obj5).getDocument();
                    $this$firstOrNull$iv = episodeDoc2.select("a.maxbutton-download-now");
                    $i$f$firstOrNull = 0;
                    it = $this$firstOrNull$iv.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            element$iv = it.next();
                            Element a2 = (Element) element$iv;
                            z = false;
                            $this$firstOrNull$iv2 = $this$firstOrNull$iv;
                            $i$f$firstOrNull2 = $i$f$firstOrNull;
                            obj6 = null;
                            matchResultFind$default = Regex.find$default(new Regex("EPISODE\\s*-\\s*0*(\\d+)", RegexOption.IGNORE_CASE), a2.text(), 0, 2, (Object) null);
                            if (matchResultFind$default == null) {
                            }
                            if (!z) {
                                obj4 = null;
                                $i$f$firstOrNull = $i$f$firstOrNull2;
                                $this$firstOrNull$iv = $this$firstOrNull$iv2;
                            }
                        } else {
                            element$iv = obj4;
                        }
                    }
                    element = (Element) element$iv;
                    if (element != null) {
                        break;
                    }
                    obj6 = Unit.INSTANCE;
                    $this$withPermit$iv2.release();
                    return obj6;
                case 2:
                    $i$f$withPermit2 = 0;
                    String seasonBtnUrl3 = (String) this.L$3;
                    Continuation $completion3 = (Continuation) this.L$2;
                    Object obj10 = this.L$1;
                    Semaphore $this$withPermit$iv6 = (Semaphore) this.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        anonymousClass1 = this;
                        $i$f$withPermit = 0;
                        obj4 = null;
                        i = 0;
                        seasonBtnUrl2 = seasonBtnUrl3;
                        $completion2 = $completion3;
                        obj2 = obj10;
                        $this$withPermit$iv2 = $this$withPermit$iv6;
                        obj5 = $result;
                        Document episodeDoc3 = ((NiceResponse) obj5).getDocument();
                        $this$firstOrNull$iv = episodeDoc3.select("a.maxbutton-download-now");
                        $i$f$firstOrNull = 0;
                        it = $this$firstOrNull$iv.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                element$iv = it.next();
                                Element a3 = (Element) element$iv;
                                z = false;
                                $this$firstOrNull$iv2 = $this$firstOrNull$iv;
                                $i$f$firstOrNull2 = $i$f$firstOrNull;
                                obj6 = null;
                                matchResultFind$default = Regex.find$default(new Regex("EPISODE\\s*-\\s*0*(\\d+)", RegexOption.IGNORE_CASE), a3.text(), 0, 2, (Object) null);
                                if (matchResultFind$default == null) {
                                }
                                if (!z) {
                                    obj4 = null;
                                    $i$f$firstOrNull = $i$f$firstOrNull2;
                                    $this$firstOrNull$iv = $this$firstOrNull$iv2;
                                }
                            } else {
                                element$iv = obj4;
                            }
                        }
                        element = (Element) element$iv;
                        if (element != null) {
                        }
                        obj6 = Unit.INSTANCE;
                        break;
                    } catch (Exception e6) {
                        e = e6;
                        obj2 = obj10;
                        $this$withPermit$iv2 = $this$withPermit$iv6;
                        Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                        $this$withPermit$iv2.release();
                        return obj6;
                    } catch (Throwable th5) {
                        th = th5;
                        $this$withPermit$iv2 = $this$withPermit$iv6;
                        $this$withPermit$iv2.release();
                        throw th;
                    }
                    $this$withPermit$iv2.release();
                    return obj6;
                case 3:
                    $i$f$withPermit2 = 0;
                    obj2 = this.L$1;
                    $this$withPermit$iv2 = (Semaphore) this.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        zinkLinks = $result;
                        obj6 = zinkLinks;
                    } catch (Exception e7) {
                        e = e7;
                        Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                    } catch (Throwable th6) {
                        th = th6;
                        $this$withPermit$iv2.release();
                        throw th;
                    }
                    $this$withPermit$iv2.release();
                    return obj6;
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
                    destination$iv$iv2.add(BuildersKt.async$default($this$coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new AnonymousClass1(semaphore, item$iv$iv, null, this.$subtitleCallback$inlined, this.$callback$inlined, this.$episode$inlined), 2, (Object) null));
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
