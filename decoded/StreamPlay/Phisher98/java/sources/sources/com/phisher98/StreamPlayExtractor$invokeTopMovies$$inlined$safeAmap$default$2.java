package com.phisher98;

import com.lagradost.api.Log;
import com.lagradost.nicehttp.NiceResponse;
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
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
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
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: StreamPlayUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeTopMovies$$inlined$safeAmap$default$2", f = "StreamPlayExtractor.kt", i = {0, 0}, l = {1898}, m = "invokeSuspend", n = {"$this$coroutineScope", "semaphore"}, nl = {-1}, s = {"L$0", "L$1"}, v = 2)
@SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2265:1\n1739#2:2266\n1814#2,3:2267\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n*L\n1887#1:2266\n1887#1:2267,3\n*E\n"})
public final class StreamPlayExtractor$invokeTopMovies$$inlined$safeAmap$default$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Unit>>, Object> {
    final /* synthetic */ Function1 $callback$inlined;
    final /* synthetic */ int $concurrency;
    final /* synthetic */ Integer $episode$inlined;
    final /* synthetic */ Function1 $subtitleCallback$inlined;
    final /* synthetic */ Iterable $this_runCatching;
    final /* synthetic */ String $topmoviesAPI$inlined;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamPlayExtractor$invokeTopMovies$$inlined$safeAmap$default$2(int i, Iterable iterable, Continuation continuation, String str, Function1 function1, Function1 function2, Integer num) {
        super(2, continuation);
        this.$concurrency = i;
        this.$this_runCatching = iterable;
        this.$topmoviesAPI$inlined = str;
        this.$subtitleCallback$inlined = function1;
        this.$callback$inlined = function2;
        this.$episode$inlined = num;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> streamPlayExtractor$invokeTopMovies$$inlined$safeAmap$default$2 = new StreamPlayExtractor$invokeTopMovies$$inlined$safeAmap$default$2(this.$concurrency, this.$this_runCatching, continuation, this.$topmoviesAPI$inlined, this.$subtitleCallback$inlined, this.$callback$inlined, this.$episode$inlined);
        streamPlayExtractor$invokeTopMovies$$inlined$safeAmap$default$2.L$0 = obj;
        return streamPlayExtractor$invokeTopMovies$$inlined$safeAmap$default$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Unit>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayExtractor$invokeTopMovies$$inlined$safeAmap$default$2$1 */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "B", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeTopMovies$$inlined$safeAmap$default$2$1", f = "StreamPlayExtractor.kt", i = {0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3}, l = {2266, 2269, 2283, 2288}, m = "invokeSuspend", n = {"$this$withPermit$iv", "$this$withPermit$iv", "$completion", "detailPageUrl", "$this$invokeTopMovies_u24lambda_u245_u240", "$this$withPermit$iv", "$completion", "detailPageUrl", "episodeLink", "detailPageDocument", "$this$withPermit$iv", "$completion", "detailPageUrl", "finalLink", "episodeLink", "detailPageDocument"}, nl = {2267, 2269, 2285, 2295}, s = {"L$0", "L$0", "L$2", "L$3", "L$4", "L$0", "L$2", "L$3", "L$4", "L$5", "L$0", "L$2", "L$3", "L$4", "L$5", "L$6"}, v = 2)
    @SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreKt\n+ 3 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2265:1\n81#2,3:2266\n85#2,2:2296\n2327#3:2269\n2326#3,9:2271\n2336#3,14:2282\n1#4:2270\n296#5,2:2280\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n*L\n1889#1:2266,3\n1889#1:2296,2\n2330#2:2280,2\n*E\n"})
    public static final class C02131 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1 $callback$inlined;
        final /* synthetic */ Integer $episode$inlined;
        final /* synthetic */ Object $item;
        final /* synthetic */ Semaphore $semaphore;
        final /* synthetic */ Function1 $subtitleCallback$inlined;
        final /* synthetic */ String $topmoviesAPI$inlined;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C02131(Semaphore semaphore, Object obj, Continuation continuation, String str, Function1 function1, Function1 function2, Integer num) {
            super(2, continuation);
            this.$semaphore = semaphore;
            this.$item = obj;
            this.$topmoviesAPI$inlined = str;
            this.$subtitleCallback$inlined = function1;
            this.$callback$inlined = function2;
            this.$episode$inlined = num;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C02131(this.$semaphore, this.$item, continuation, this.$topmoviesAPI$inlined, this.$subtitleCallback$inlined, this.$callback$inlined, this.$episode$inlined);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:111:0x02d6 A[ADDED_TO_REGION, REMOVE] */
        /* JADX WARN: Code duplicated, block: B:158:0x01b6 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:33:0x00fa A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:34:0x00fb  */
        /* JADX WARN: Code duplicated, block: B:46:0x0149  */
        /* JADX WARN: Code duplicated, block: B:49:0x014e A[Catch: all -> 0x005f, Exception -> 0x0062, TRY_ENTER, TRY_LEAVE, TryCatch #17 {Exception -> 0x0062, blocks: (B:7:0x0031, B:10:0x0054, B:49:0x014e, B:43:0x0139), top: B:149:0x0009 }] */
        /* JADX WARN: Code duplicated, block: B:52:0x0157 A[Catch: all -> 0x02ea, Exception -> 0x02ee, TRY_ENTER, TryCatch #19 {Exception -> 0x02ee, all -> 0x02ea, blocks: (B:44:0x0143, B:47:0x014a, B:52:0x0157, B:53:0x0165, B:55:0x016b), top: B:150:0x0143 }] */
        /* JADX WARN: Code duplicated, block: B:55:0x016b A[Catch: all -> 0x02ea, Exception -> 0x02ee, TRY_LEAVE, TryCatch #19 {Exception -> 0x02ee, all -> 0x02ea, blocks: (B:44:0x0143, B:47:0x014a, B:52:0x0157, B:53:0x0165, B:55:0x016b), top: B:150:0x0143 }] */
        /* JADX WARN: Code duplicated, block: B:60:0x01aa A[LOOP:0: B:53:0x0165->B:60:0x01aa, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:66:0x01c0 A[Catch: all -> 0x02e1, Exception -> 0x02e5, TryCatch #1 {all -> 0x02e1, blocks: (B:57:0x0188, B:64:0x01bb, B:66:0x01c0, B:68:0x01c7, B:70:0x01d0, B:72:0x01d9, B:77:0x01e8, B:79:0x01f3, B:81:0x01f9, B:112:0x02d7), top: B:134:0x0188 }] */
        /* JADX WARN: Code duplicated, block: B:87:0x0225 A[Catch: all -> 0x005f, Exception -> 0x0237, TRY_LEAVE, TryCatch #4 {Exception -> 0x0237, blocks: (B:85:0x0221, B:87:0x0225), top: B:138:0x0221 }] */
        /* JADX WARN: Code duplicated, block: B:89:0x022a  */
        /* JADX WARN: Code duplicated, block: B:98:0x029b A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:99:0x029c  */
        public final Object invokeSuspend(Object obj) throws Throwable {
            Regex regex;
            Semaphore semaphore;
            Object obj2;
            Object obj3;
            Object obj4;
            int i;
            Semaphore semaphore2;
            int i2;
            Continuation continuation;
            String str;
            String str2;
            int i3;
            int i4;
            Continuation continuation2;
            int i5;
            Semaphore semaphore3;
            Object objSafeGet$default;
            Object obj5;
            Semaphore semaphore4;
            Object obj6;
            Document document;
            Iterator it;
            Document document2;
            int i6;
            Object next;
            Element element;
            Element elementParent;
            Element elementClosest;
            String strAttr;
            String str3;
            int i7;
            Semaphore semaphore5;
            String str4;
            String str5;
            int i8;
            String str6;
            Continuation continuation3;
            Object obj7;
            Object objBypassHrefli;
            int i9;
            String strText;
            Semaphore semaphore6;
            Object objLoadSourceNameExtractor$default;
            Object obj8;
            String str7;
            C02131 c02131 = this;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                try {
                    switch (c02131.label) {
                        case 0:
                            ResultKt.throwOnFailure(obj);
                            Semaphore semaphore7 = c02131.$semaphore;
                            Object obj9 = c02131.$item;
                            c02131.L$0 = semaphore7;
                            c02131.L$1 = obj9;
                            c02131.label = 1;
                            if (semaphore7.acquire((Continuation) c02131) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            obj4 = obj9;
                            i = 0;
                            semaphore2 = semaphore7;
                            i2 = 0;
                            try {
                                continuation = (Continuation) c02131;
                                str = (String) obj4;
                                StreamPlayExtractor streamPlayExtractor = StreamPlayExtractor.INSTANCE;
                                try {
                                    Result.Companion companion = Result.Companion;
                                    c02131.L$0 = semaphore2;
                                    c02131.L$1 = obj4;
                                    c02131.L$2 = SpillingKt.nullOutSpilledVariable(continuation);
                                    c02131.L$3 = SpillingKt.nullOutSpilledVariable(str);
                                    c02131.L$4 = SpillingKt.nullOutSpilledVariable(streamPlayExtractor);
                                    c02131.label = 2;
                                    semaphore3 = semaphore2;
                                    try {
                                        objSafeGet$default = StreamPlayUtilsKt.safeGet$default(str, null, null, null, null, false, 0, this, 126, null);
                                        c02131 = this;
                                        if (objSafeGet$default == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        str2 = str;
                                        i3 = i;
                                        obj5 = obj4;
                                        continuation2 = continuation;
                                        i5 = 0;
                                        semaphore4 = semaphore3;
                                        try {
                                            obj6 = Result.constructor-impl(((NiceResponse) objSafeGet$default).getDocument());
                                            semaphore = semaphore4;
                                            i4 = i2;
                                            obj2 = obj5;
                                        } catch (Throwable th) {
                                            th = th;
                                            semaphore = semaphore4;
                                            i4 = i2;
                                            obj2 = obj5;
                                            Result.Companion companion2 = Result.Companion;
                                            obj6 = Result.constructor-impl(ResultKt.createFailure(th));
                                        }
                                        try {
                                            if (Result.isFailure-impl(obj6)) {
                                                obj6 = null;
                                            }
                                            document = (Document) obj6;
                                            if (document == null) {
                                                obj3 = Unit.INSTANCE;
                                            } else {
                                                it = document.select("span strong").iterator();
                                                while (true) {
                                                    if (it.hasNext()) {
                                                        next = it.next();
                                                        strText = ((Element) next).text();
                                                        document2 = document;
                                                        i6 = i3;
                                                        try {
                                                            try {
                                                                regex = new Regex(".*Episode\\s+" + c02131.$episode$inlined + ".*", RegexOption.IGNORE_CASE);
                                                                if (!regex.matches(strText)) {
                                                                    document = document2;
                                                                    i3 = i6;
                                                                }
                                                            } catch (Exception e) {
                                                                e = e;
                                                                regex = null;
                                                            }
                                                        } catch (Throwable th2) {
                                                            th = th2;
                                                            semaphore.release();
                                                            throw th;
                                                        }
                                                    } else {
                                                        document2 = document;
                                                        i6 = i3;
                                                        next = null;
                                                    }
                                                }
                                                try {
                                                    element = (Element) next;
                                                    try {
                                                        if (element == null && (elementParent = element.parent()) != null && (elementClosest = elementParent.closest("a")) != null && (strAttr = elementClosest.attr("href")) != null) {
                                                            if (StringsKt.isBlank(strAttr)) {
                                                                strAttr = null;
                                                            }
                                                            if (strAttr != null) {
                                                                str3 = strAttr;
                                                                regex = null;
                                                                regex = null;
                                                                if (StringsKt.contains$default(str3, "unblockedgames", false, 2, (Object) null)) {
                                                                    c02131.L$0 = semaphore;
                                                                    c02131.L$1 = obj2;
                                                                    c02131.L$2 = SpillingKt.nullOutSpilledVariable(continuation2);
                                                                    c02131.L$3 = SpillingKt.nullOutSpilledVariable(str2);
                                                                    c02131.L$4 = SpillingKt.nullOutSpilledVariable(str3);
                                                                    c02131.L$5 = SpillingKt.nullOutSpilledVariable(document2);
                                                                    c02131.label = 3;
                                                                    objBypassHrefli = StreamPlayUtilsKt.bypassHrefli(str3, c02131);
                                                                    if (objBypassHrefli == coroutine_suspended) {
                                                                        return coroutine_suspended;
                                                                    }
                                                                    i9 = i6;
                                                                    try {
                                                                        str7 = (String) objBypassHrefli;
                                                                        if (str7 == null) {
                                                                            obj3 = Unit.INSTANCE;
                                                                        } else {
                                                                            Semaphore semaphore8 = semaphore;
                                                                            i7 = i5;
                                                                            semaphore5 = semaphore8;
                                                                            i6 = i9;
                                                                            str5 = str3;
                                                                            str4 = str7;
                                                                            i8 = i4;
                                                                            str6 = str2;
                                                                            continuation3 = continuation2;
                                                                            obj7 = obj2;
                                                                            regex = regex;
                                                                        }
                                                                    } catch (Exception e2) {
                                                                        e = e2;
                                                                    }
                                                                } else {
                                                                    Semaphore semaphore9 = semaphore;
                                                                    i7 = i5;
                                                                    semaphore5 = semaphore9;
                                                                    str4 = str3;
                                                                    str5 = str4;
                                                                    i8 = i4;
                                                                    str6 = str2;
                                                                    continuation3 = continuation2;
                                                                    obj7 = obj2;
                                                                }
                                                                try {
                                                                    String str8 = c02131.$topmoviesAPI$inlined + '/';
                                                                    Function1 function1 = c02131.$subtitleCallback$inlined;
                                                                    Function1 function2 = c02131.$callback$inlined;
                                                                    c02131.L$0 = semaphore5;
                                                                    c02131.L$1 = obj7;
                                                                    c02131.L$2 = SpillingKt.nullOutSpilledVariable(continuation3);
                                                                    c02131.L$3 = SpillingKt.nullOutSpilledVariable(str6);
                                                                    c02131.L$4 = SpillingKt.nullOutSpilledVariable(str4);
                                                                    c02131.L$5 = SpillingKt.nullOutSpilledVariable(str5);
                                                                    c02131.L$6 = SpillingKt.nullOutSpilledVariable(document2);
                                                                    c02131.label = 4;
                                                                    semaphore6 = semaphore5;
                                                                    Object obj10 = obj7;
                                                                    try {
                                                                        objLoadSourceNameExtractor$default = StreamPlayUtilsKt.loadSourceNameExtractor$default("TopMovies", str4, str8, function1, function2, null, null, c02131, 96, null);
                                                                        if (objLoadSourceNameExtractor$default == coroutine_suspended) {
                                                                            return coroutine_suspended;
                                                                        }
                                                                        obj8 = objLoadSourceNameExtractor$default;
                                                                        semaphore = semaphore6;
                                                                        obj3 = obj8;
                                                                    } catch (Exception e3) {
                                                                        e = e3;
                                                                        semaphore = semaphore6;
                                                                        obj2 = obj10;
                                                                        Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                                                                        obj3 = regex;
                                                                    } catch (Throwable th3) {
                                                                        th = th3;
                                                                        semaphore = semaphore6;
                                                                        semaphore.release();
                                                                        throw th;
                                                                    }
                                                                } catch (Exception e4) {
                                                                    e = e4;
                                                                    semaphore = semaphore5;
                                                                    obj2 = obj7;
                                                                } catch (Throwable th4) {
                                                                    th = th4;
                                                                    semaphore = semaphore5;
                                                                }
                                                            }
                                                            Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                                                            obj3 = regex;
                                                        }
                                                        obj3 = Unit.INSTANCE;
                                                    } catch (Exception e5) {
                                                        e = e5;
                                                    }
                                                } catch (Exception e6) {
                                                    e = e6;
                                                    regex = null;
                                                }
                                            }
                                        } catch (Exception e7) {
                                            e = e7;
                                            regex = null;
                                        } catch (Throwable th5) {
                                            th = th5;
                                        }
                                        semaphore.release();
                                        return obj3;
                                    } catch (Throwable th6) {
                                        th = th6;
                                        c02131 = this;
                                        str2 = str;
                                        i3 = i;
                                        obj2 = obj4;
                                        i4 = 0;
                                        continuation2 = continuation;
                                        i5 = 0;
                                        semaphore = semaphore3;
                                        Result.Companion companion3 = Result.Companion;
                                        obj6 = Result.constructor-impl(ResultKt.createFailure(th));
                                        if (Result.isFailure-impl(obj6)) {
                                            obj6 = null;
                                        }
                                        document = (Document) obj6;
                                        if (document == null) {
                                            obj3 = Unit.INSTANCE;
                                        } else {
                                            it = document.select("span strong").iterator();
                                            while (true) {
                                                if (it.hasNext()) {
                                                    next = it.next();
                                                    strText = ((Element) next).text();
                                                    document2 = document;
                                                    i6 = i3;
                                                    regex = new Regex(".*Episode\\s+" + c02131.$episode$inlined + ".*", RegexOption.IGNORE_CASE);
                                                    if (!regex.matches(strText)) {
                                                        document = document2;
                                                        i3 = i6;
                                                    }
                                                } else {
                                                    document2 = document;
                                                    i6 = i3;
                                                    next = null;
                                                }
                                            }
                                            element = (Element) next;
                                            if (element == null) {
                                            }
                                            obj3 = Unit.INSTANCE;
                                        }
                                        semaphore.release();
                                        return obj3;
                                    }
                                } catch (Throwable th7) {
                                    th = th7;
                                    Semaphore semaphore10 = semaphore2;
                                    str2 = str;
                                    i3 = i;
                                    obj2 = obj4;
                                    i4 = 0;
                                    continuation2 = continuation;
                                    i5 = 0;
                                    semaphore = semaphore10;
                                }
                            } catch (Exception e8) {
                                e = e8;
                                regex = null;
                                obj2 = obj4;
                                semaphore = semaphore2;
                            } catch (Throwable th8) {
                                th = th8;
                                semaphore = semaphore2;
                                semaphore.release();
                                throw th;
                            }
                            break;
                        case 1:
                            Object obj11 = c02131.L$1;
                            Semaphore semaphore11 = (Semaphore) c02131.L$0;
                            ResultKt.throwOnFailure(obj);
                            i = 0;
                            obj4 = obj11;
                            semaphore2 = semaphore11;
                            i2 = 0;
                            continuation = (Continuation) c02131;
                            str = (String) obj4;
                            StreamPlayExtractor streamPlayExtractor2 = StreamPlayExtractor.INSTANCE;
                            Result.Companion companion4 = Result.Companion;
                            c02131.L$0 = semaphore2;
                            c02131.L$1 = obj4;
                            c02131.L$2 = SpillingKt.nullOutSpilledVariable(continuation);
                            c02131.L$3 = SpillingKt.nullOutSpilledVariable(str);
                            c02131.L$4 = SpillingKt.nullOutSpilledVariable(streamPlayExtractor2);
                            c02131.label = 2;
                            semaphore3 = semaphore2;
                            objSafeGet$default = StreamPlayUtilsKt.safeGet$default(str, null, null, null, null, false, 0, this, 126, null);
                            c02131 = this;
                            if (objSafeGet$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            str2 = str;
                            i3 = i;
                            obj5 = obj4;
                            continuation2 = continuation;
                            i5 = 0;
                            semaphore4 = semaphore3;
                            obj6 = Result.constructor-impl(((NiceResponse) objSafeGet$default).getDocument());
                            semaphore = semaphore4;
                            i4 = i2;
                            obj2 = obj5;
                            if (Result.isFailure-impl(obj6)) {
                                obj6 = null;
                            }
                            document = (Document) obj6;
                            if (document == null) {
                                obj3 = Unit.INSTANCE;
                            } else {
                                it = document.select("span strong").iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        next = it.next();
                                        strText = ((Element) next).text();
                                        document2 = document;
                                        i6 = i3;
                                        regex = new Regex(".*Episode\\s+" + c02131.$episode$inlined + ".*", RegexOption.IGNORE_CASE);
                                        if (!regex.matches(strText)) {
                                            document = document2;
                                            i3 = i6;
                                        }
                                    } else {
                                        document2 = document;
                                        i6 = i3;
                                        next = null;
                                    }
                                }
                                element = (Element) next;
                                if (element == null) {
                                }
                                obj3 = Unit.INSTANCE;
                            }
                            semaphore.release();
                            return obj3;
                        case 2:
                            i3 = 0;
                            i4 = 0;
                            i5 = 0;
                            str2 = (String) c02131.L$3;
                            continuation2 = (Continuation) c02131.L$2;
                            obj5 = c02131.L$1;
                            semaphore4 = (Semaphore) c02131.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                i2 = 0;
                                objSafeGet$default = obj;
                                obj6 = Result.constructor-impl(((NiceResponse) objSafeGet$default).getDocument());
                                semaphore = semaphore4;
                                i4 = i2;
                                obj2 = obj5;
                            } catch (Throwable th9) {
                                th = th9;
                                semaphore = semaphore4;
                                obj2 = obj5;
                                Result.Companion companion5 = Result.Companion;
                                obj6 = Result.constructor-impl(ResultKt.createFailure(th));
                                if (Result.isFailure-impl(obj6)) {
                                    obj6 = null;
                                }
                                document = (Document) obj6;
                                if (document == null) {
                                    obj3 = Unit.INSTANCE;
                                } else {
                                    it = document.select("span strong").iterator();
                                    while (true) {
                                        if (it.hasNext()) {
                                            next = it.next();
                                            strText = ((Element) next).text();
                                            document2 = document;
                                            i6 = i3;
                                            regex = new Regex(".*Episode\\s+" + c02131.$episode$inlined + ".*", RegexOption.IGNORE_CASE);
                                            if (!regex.matches(strText)) {
                                                document = document2;
                                                i3 = i6;
                                            }
                                        } else {
                                            document2 = document;
                                            i6 = i3;
                                            next = null;
                                        }
                                    }
                                    element = (Element) next;
                                    if (element == null) {
                                    }
                                    obj3 = Unit.INSTANCE;
                                }
                                semaphore.release();
                                return obj3;
                            }
                            if (Result.isFailure-impl(obj6)) {
                                obj6 = null;
                            }
                            document = (Document) obj6;
                            if (document == null) {
                                obj3 = Unit.INSTANCE;
                            } else {
                                it = document.select("span strong").iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        next = it.next();
                                        strText = ((Element) next).text();
                                        document2 = document;
                                        i6 = i3;
                                        regex = new Regex(".*Episode\\s+" + c02131.$episode$inlined + ".*", RegexOption.IGNORE_CASE);
                                        if (!regex.matches(strText)) {
                                            document = document2;
                                            i3 = i6;
                                        }
                                    } else {
                                        document2 = document;
                                        i6 = i3;
                                        next = null;
                                    }
                                }
                                element = (Element) next;
                                if (element == null) {
                                }
                                obj3 = Unit.INSTANCE;
                            }
                            semaphore.release();
                            return obj3;
                        case 3:
                            i9 = 0;
                            i4 = 0;
                            Document document3 = (Document) c02131.L$5;
                            str3 = (String) c02131.L$4;
                            str2 = (String) c02131.L$3;
                            continuation2 = (Continuation) c02131.L$2;
                            obj2 = c02131.L$1;
                            semaphore = (Semaphore) c02131.L$0;
                            ResultKt.throwOnFailure(obj);
                            document2 = document3;
                            regex = null;
                            i5 = 0;
                            objBypassHrefli = obj;
                            str7 = (String) objBypassHrefli;
                            if (str7 == null) {
                                obj3 = Unit.INSTANCE;
                            } else {
                                Semaphore semaphore12 = semaphore;
                                i7 = i5;
                                semaphore5 = semaphore12;
                                i6 = i9;
                                str5 = str3;
                                str4 = str7;
                                i8 = i4;
                                str6 = str2;
                                continuation3 = continuation2;
                                obj7 = obj2;
                                regex = regex;
                                String str9 = c02131.$topmoviesAPI$inlined + '/';
                                Function1 function3 = c02131.$subtitleCallback$inlined;
                                Function1 function4 = c02131.$callback$inlined;
                                c02131.L$0 = semaphore5;
                                c02131.L$1 = obj7;
                                c02131.L$2 = SpillingKt.nullOutSpilledVariable(continuation3);
                                c02131.L$3 = SpillingKt.nullOutSpilledVariable(str6);
                                c02131.L$4 = SpillingKt.nullOutSpilledVariable(str4);
                                c02131.L$5 = SpillingKt.nullOutSpilledVariable(str5);
                                c02131.L$6 = SpillingKt.nullOutSpilledVariable(document2);
                                c02131.label = 4;
                                semaphore6 = semaphore5;
                                Object obj12 = obj7;
                                objLoadSourceNameExtractor$default = StreamPlayUtilsKt.loadSourceNameExtractor$default("TopMovies", str4, str9, function3, function4, null, null, c02131, 96, null);
                                if (objLoadSourceNameExtractor$default == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                obj8 = objLoadSourceNameExtractor$default;
                                semaphore = semaphore6;
                                obj3 = obj8;
                            }
                            semaphore.release();
                            return obj3;
                        case 4:
                            Object obj13 = c02131.L$1;
                            semaphore = (Semaphore) c02131.L$0;
                            ResultKt.throwOnFailure(obj);
                            i6 = 0;
                            obj8 = obj;
                            obj3 = obj8;
                            semaphore.release();
                            return obj3;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } catch (Exception e9) {
                    e = e9;
                    regex = null;
                }
            } catch (Throwable th10) {
                th = th10;
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
                    destination$iv$iv2.add(BuildersKt.async$default($this$coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new C02131(semaphore, item$iv$iv, null, this.$topmoviesAPI$inlined, this.$subtitleCallback$inlined, this.$callback$inlined, this.$episode$inlined), 2, (Object) null));
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
