package com.phisher98;

import com.lagradost.api.Log;
import com.lagradost.nicehttp.NiceResponse;
import java.util.ArrayList;
import java.util.Collection;
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
import kotlin.jvm.internal.Intrinsics;
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
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: StreamPlayUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeMovies4u$$inlined$safeAmap$default$1", f = "StreamPlayExtractor.kt", i = {0, 0}, l = {1898}, m = "invokeSuspend", n = {"$this$coroutineScope", "semaphore"}, nl = {-1}, s = {"L$0", "L$1"}, v = 2)
@SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2265:1\n1739#2:2266\n1814#2,3:2267\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n*L\n1887#1:2266\n1887#1:2267,3\n*E\n"})
public final class StreamPlayExtractor$invokeMovies4u$$inlined$safeAmap$default$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Object>>, Object> {
    final /* synthetic */ Function1 $callback$inlined;
    final /* synthetic */ int $concurrency;
    final /* synthetic */ Integer $episode$inlined;
    final /* synthetic */ String $id$inlined;
    final /* synthetic */ Integer $season$inlined;
    final /* synthetic */ Function1 $subtitleCallback$inlined;
    final /* synthetic */ Iterable $this_runCatching;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamPlayExtractor$invokeMovies4u$$inlined$safeAmap$default$1(int i, Iterable iterable, Continuation continuation, String str, Integer num, Function1 function1, Function1 function2, Integer num2) {
        super(2, continuation);
        this.$concurrency = i;
        this.$this_runCatching = iterable;
        this.$id$inlined = str;
        this.$season$inlined = num;
        this.$subtitleCallback$inlined = function1;
        this.$callback$inlined = function2;
        this.$episode$inlined = num2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> streamPlayExtractor$invokeMovies4u$$inlined$safeAmap$default$1 = new StreamPlayExtractor$invokeMovies4u$$inlined$safeAmap$default$1(this.$concurrency, this.$this_runCatching, continuation, this.$id$inlined, this.$season$inlined, this.$subtitleCallback$inlined, this.$callback$inlined, this.$episode$inlined);
        streamPlayExtractor$invokeMovies4u$$inlined$safeAmap$default$1.L$0 = obj;
        return streamPlayExtractor$invokeMovies4u$$inlined$safeAmap$default$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Object>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayExtractor$invokeMovies4u$$inlined$safeAmap$default$1$1 */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "B", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeMovies4u$$inlined$safeAmap$default$1$1", f = "StreamPlayExtractor.kt", i = {0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {2266, 2270, 2280, 2287, 2296}, m = "invokeSuspend", n = {"$this$withPermit$iv", "$this$withPermit$iv", "$completion", "element", "postUrl", "$this$withPermit$iv", "$completion", "element", "postUrl", "postDoc", "imdbId", "innerUrl", "$this$withPermit$iv", "$completion", "element", "postUrl", "postDoc", "imdbId", "innerUrl", "innerDoc", "sourceButtons", "$this$safeAmap_u24default$iv", "$completion$iv", "$this$safeAmap_u24lambda_u240$iv", "concurrency$iv", "$this$withPermit$iv", "$completion", "element", "postUrl", "postDoc", "imdbId", "seasonBlocks", "$this$safeAmap_u24default$iv", "$completion$iv", "$this$safeAmap_u24lambda_u240$iv", "concurrency$iv"}, nl = {2267, 2271, 2281, 2288, 2297}, s = {"L$0", "L$0", "L$2", "L$3", "L$4", "L$0", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "I$0", "L$0", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "I$0"}, v = 2)
    @SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreKt\n+ 3 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n+ 4 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt\n*L\n1#1,2265:1\n81#2,3:2266\n85#2,2:2300\n4661#3,14:2269\n4685#3,2:2290\n4712#3:2299\n1880#4,5:2283\n1899#4,2:2288\n1880#4,5:2292\n1899#4,2:2297\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n*L\n1889#1:2266,3\n1889#1:2300,2\n4674#2:2283,5\n4674#2:2288,2\n4686#2:2292,5\n4686#2:2297,2\n*E\n"})
    public static final class C01811 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {
        final /* synthetic */ Function1 $callback$inlined;
        final /* synthetic */ Integer $episode$inlined;
        final /* synthetic */ String $id$inlined;
        final /* synthetic */ Object $item;
        final /* synthetic */ Integer $season$inlined;
        final /* synthetic */ Semaphore $semaphore;
        final /* synthetic */ Function1 $subtitleCallback$inlined;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
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
        public C01811(Semaphore semaphore, Object obj, Continuation continuation, String str, Integer num, Function1 function1, Function1 function2, Integer num2) {
            super(2, continuation);
            this.$semaphore = semaphore;
            this.$item = obj;
            this.$id$inlined = str;
            this.$season$inlined = num;
            this.$subtitleCallback$inlined = function1;
            this.$callback$inlined = function2;
            this.$episode$inlined = num2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C01811(this.$semaphore, this.$item, continuation, this.$id$inlined, this.$season$inlined, this.$subtitleCallback$inlined, this.$callback$inlined, this.$episode$inlined);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Object> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:170:0x01d7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:38:0x01a9 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:39:0x01aa  */
        /* JADX WARN: Code duplicated, block: B:50:0x01ec A[Catch: Exception -> 0x0453, all -> 0x0458, TRY_ENTER, TryCatch #19 {Exception -> 0x0453, blocks: (B:42:0x01c0, B:50:0x01ec, B:52:0x01f0), top: B:156:0x01c0 }] */
        /* JADX WARN: Code duplicated, block: B:52:0x01f0 A[Catch: Exception -> 0x0453, all -> 0x0458, TRY_LEAVE, TryCatch #19 {Exception -> 0x0453, blocks: (B:42:0x01c0, B:50:0x01ec, B:52:0x01f0), top: B:156:0x01c0 }] */
        /* JADX WARN: Code duplicated, block: B:56:0x0247 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:57:0x0248  */
        /* JADX WARN: Code duplicated, block: B:66:0x02dc A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:67:0x02dd  */
        /* JADX WARN: Code duplicated, block: B:88:0x0361  */
        /* JADX WARN: Code duplicated, block: B:95:0x03e0 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:96:0x03e1  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Not initialized variable reg: 13, insn: 0x0356: MOVE (r1 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r13 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('$i$f$withPermit' int)]), block:B:85:0x0355 */
        /* JADX WARN: Type inference failed for: r11v14 */
        /* JADX WARN: Type inference failed for: r11v16, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r11v23 */
        /* JADX WARN: Type inference failed for: r12v1 */
        /* JADX WARN: Type inference failed for: r12v14 */
        /* JADX WARN: Type inference failed for: r12v15 */
        /* JADX WARN: Type inference failed for: r12v17 */
        /* JADX WARN: Type inference failed for: r12v19, types: [kotlinx.coroutines.sync.Semaphore] */
        /* JADX WARN: Type inference failed for: r12v2, types: [kotlinx.coroutines.sync.Semaphore] */
        /* JADX WARN: Type inference failed for: r12v21 */
        /* JADX WARN: Type inference failed for: r12v22 */
        /* JADX WARN: Type inference failed for: r12v23 */
        /* JADX WARN: Type inference failed for: r12v27 */
        /* JADX WARN: Type inference failed for: r12v28 */
        /* JADX WARN: Type inference failed for: r12v29 */
        /* JADX WARN: Type inference failed for: r12v3 */
        /* JADX WARN: Type inference failed for: r12v30 */
        /* JADX WARN: Type inference failed for: r12v31 */
        /* JADX WARN: Type inference failed for: r12v4 */
        /* JADX WARN: Type inference failed for: r12v5 */
        /* JADX WARN: Type inference failed for: r12v6 */
        /* JADX WARN: Type inference failed for: r12v7 */
        /* JADX WARN: Type inference failed for: r12v8 */
        /* JADX WARN: Type inference failed for: r12v9 */
        /* JADX WARN: Type inference failed for: r20v10 */
        /* JADX WARN: Type inference failed for: r20v11 */
        /* JADX WARN: Type inference failed for: r20v13 */
        /* JADX WARN: Type inference failed for: r20v14 */
        /* JADX WARN: Type inference failed for: r20v19 */
        /* JADX WARN: Type inference failed for: r20v20 */
        /* JADX WARN: Type inference failed for: r20v4 */
        /* JADX WARN: Type inference failed for: r20v6 */
        /* JADX WARN: Type inference failed for: r20v7 */
        /* JADX WARN: Type inference failed for: r20v8 */
        /* JADX WARN: Type inference failed for: r20v9 */
        /* JADX WARN: Type inference failed for: r2v57 */
        /* JADX WARN: Type inference failed for: r2v58, types: [kotlinx.coroutines.sync.Semaphore] */
        /* JADX WARN: Type inference failed for: r2v60 */
        /* JADX WARN: Type inference failed for: r2v67 */
        public final Object invokeSuspend(Object obj) throws Throwable {
            ?? r12;
            Semaphore semaphore;
            char c;
            Object obj2;
            int i;
            Unit unit;
            Object obj3;
            int i2;
            Continuation continuation;
            int i3;
            String strAttr;
            Element element;
            Object objSafeGet$default;
            Semaphore semaphore2;
            String str;
            Document document;
            String strSubstringBefore$default;
            Unit unit2;
            Document document2;
            Semaphore semaphore3;
            Continuation continuation2;
            Semaphore semaphore4;
            String str2;
            Object objCoroutineScope;
            Semaphore semaphore5;
            String strAttr2;
            String str3;
            ?? r11;
            Object objSafeGet$default2;
            Document document3;
            String str4;
            Continuation continuation3;
            Element element2;
            ?? r20;
            int i4;
            Object objCoroutineScope2;
            ?? r21;
            Semaphore semaphore6;
            ?? r2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        Semaphore semaphore7 = this.$semaphore;
                        Object obj4 = this.$item;
                        this.L$0 = semaphore7;
                        this.L$1 = obj4;
                        this.label = 1;
                        if (semaphore7.acquire((Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        semaphore = semaphore7;
                        c = 0;
                        obj2 = obj4;
                        i = 0;
                        try {
                            Element element3 = (Element) obj2;
                            continuation = (Continuation) this;
                            i3 = 0;
                            strAttr = element3.attr("href");
                            this.L$0 = semaphore;
                            this.L$1 = obj2;
                            this.L$2 = SpillingKt.nullOutSpilledVariable(continuation);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(element3);
                            this.L$4 = SpillingKt.nullOutSpilledVariable(strAttr);
                            this.label = 2;
                            element = element3;
                            objSafeGet$default = StreamPlayUtilsKt.safeGet$default(strAttr, null, null, null, null, false, 0, this, 126, null);
                            if (objSafeGet$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            semaphore2 = semaphore;
                            str = strAttr;
                            try {
                                try {
                                    document = ((NiceResponse) objSafeGet$default).getDocument();
                                    try {
                                        strSubstringBefore$default = StringsKt.substringBefore$default(StringsKt.substringAfter$default(document.select("p a:contains(IMDb Rating)").attr("href"), "title/", (String) null, 2, (Object) null), "/", (String) null, 2, (Object) null);
                                        if (!Intrinsics.areEqual(strSubstringBefore$default, String.valueOf(this.$id$inlined))) {
                                            try {
                                                unit2 = Unit.INSTANCE;
                                                r2 = semaphore2;
                                            } catch (Exception e) {
                                                e = e;
                                                r12 = semaphore2;
                                                unit = null;
                                                obj3 = obj2;
                                                i2 = i;
                                                Log.INSTANCE.e("safeMap", "Request failed for " + obj3 + ' ' + e);
                                                r2 = r12;
                                                unit2 = unit;
                                            } catch (Throwable th) {
                                                th = th;
                                                r12 = semaphore2;
                                                r12.release();
                                                throw th;
                                            }
                                            r2.release();
                                            return unit2;
                                        }
                                        try {
                                            if (this.$season$inlined == null) {
                                                strAttr2 = document.select("div.download-links-div a.btn").attr("href");
                                                this.L$0 = semaphore2;
                                                this.L$1 = obj2;
                                                this.L$2 = SpillingKt.nullOutSpilledVariable(continuation);
                                                this.L$3 = SpillingKt.nullOutSpilledVariable(element);
                                                this.L$4 = SpillingKt.nullOutSpilledVariable(str);
                                                this.L$5 = SpillingKt.nullOutSpilledVariable(document);
                                                this.L$6 = SpillingKt.nullOutSpilledVariable(strSubstringBefore$default);
                                                this.L$7 = SpillingKt.nullOutSpilledVariable(strAttr2);
                                                this.label = 3;
                                                str3 = strSubstringBefore$default;
                                                r11 = semaphore2;
                                                unit = null;
                                                objSafeGet$default2 = StreamPlayUtilsKt.safeGet$default(strAttr2, null, null, null, null, false, 0, this, 126, null);
                                                if (objSafeGet$default2 == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                document3 = document;
                                                i2 = i;
                                                str4 = strAttr2;
                                                continuation3 = continuation;
                                                element2 = element;
                                                try {
                                                    Document document4 = ((NiceResponse) objSafeGet$default2).getDocument();
                                                    Iterable iterableSelect = document4.select("div.downloads-btns-div a.btn");
                                                    Iterable iterable = iterableSelect;
                                                    try {
                                                        Result.Companion companion = Result.Companion;
                                                        try {
                                                            C0183x5cf40512 c0183x5cf40512 = new C0183x5cf40512(7, iterable, null, this.$subtitleCallback$inlined, this.$callback$inlined);
                                                            this.L$0 = r11;
                                                            this.L$1 = obj2;
                                                            i4 = i2;
                                                            try {
                                                                this.L$2 = SpillingKt.nullOutSpilledVariable(continuation3);
                                                                this.L$3 = SpillingKt.nullOutSpilledVariable(element2);
                                                                this.L$4 = SpillingKt.nullOutSpilledVariable(str);
                                                                this.L$5 = SpillingKt.nullOutSpilledVariable(document3);
                                                                this.L$6 = SpillingKt.nullOutSpilledVariable(str3);
                                                                this.L$7 = SpillingKt.nullOutSpilledVariable(str4);
                                                                this.L$8 = SpillingKt.nullOutSpilledVariable(document4);
                                                                this.L$9 = SpillingKt.nullOutSpilledVariable(iterableSelect);
                                                                this.L$10 = SpillingKt.nullOutSpilledVariable(iterable);
                                                                this.L$11 = SpillingKt.nullOutSpilledVariable(this);
                                                                this.L$12 = SpillingKt.nullOutSpilledVariable(iterable);
                                                                this.I$0 = 7;
                                                                this.label = 4;
                                                                objCoroutineScope2 = CoroutineScopeKt.coroutineScope(c0183x5cf40512, this);
                                                                if (objCoroutineScope2 == coroutine_suspended) {
                                                                    return coroutine_suspended;
                                                                }
                                                                r20 = r11;
                                                                i2 = i4;
                                                                try {
                                                                    Result.constructor-impl((List) objCoroutineScope2);
                                                                    r21 = r20;
                                                                    break;
                                                                } catch (Throwable th2) {
                                                                    th = th2;
                                                                    try {
                                                                        Result.Companion companion2 = Result.Companion;
                                                                        Result.constructor-impl(ResultKt.createFailure(th));
                                                                        r21 = r20;
                                                                    } catch (Exception e2) {
                                                                        e = e2;
                                                                        obj3 = obj2;
                                                                        r12 = r20;
                                                                    } catch (Throwable th3) {
                                                                        th = th3;
                                                                        r12 = r20;
                                                                        r12.release();
                                                                        throw th;
                                                                    }
                                                                    break;
                                                                }
                                                                r12 = r21;
                                                                obj3 = obj2;
                                                                try {
                                                                    r2 = r12;
                                                                    unit2 = Unit.INSTANCE;
                                                                } catch (Exception e3) {
                                                                    e = e3;
                                                                    Log.INSTANCE.e("safeMap", "Request failed for " + obj3 + ' ' + e);
                                                                    r2 = r12;
                                                                    unit2 = unit;
                                                                }
                                                                r2.release();
                                                                return unit2;
                                                            } catch (Throwable th4) {
                                                                th = th4;
                                                                r20 = r11;
                                                                i2 = i4;
                                                                Result.Companion companion3 = Result.Companion;
                                                                Result.constructor-impl(ResultKt.createFailure(th));
                                                                r21 = r20;
                                                                r12 = r21;
                                                                obj3 = obj2;
                                                                r2 = r12;
                                                                unit2 = Unit.INSTANCE;
                                                                r2.release();
                                                                return unit2;
                                                            }
                                                        } catch (Throwable th5) {
                                                            th = th5;
                                                            r20 = r11;
                                                            i2 = i2;
                                                        }
                                                    } catch (Throwable th6) {
                                                        th = th6;
                                                        r20 = r11;
                                                        i2 = i2;
                                                    }
                                                } catch (Exception e4) {
                                                    e = e4;
                                                    r12 = r11;
                                                    obj3 = obj2;
                                                }
                                            } else {
                                                document2 = document;
                                                unit = null;
                                                semaphore3 = semaphore2;
                                                Iterable iterableSelect2 = document2.select("div.downloads-btns-div");
                                                Iterable iterable2 = iterableSelect2;
                                                try {
                                                    Result.Companion companion4 = Result.Companion;
                                                    try {
                                                        C0184x5cf40513 c0184x5cf40513 = new C0184x5cf40513(7, iterable2, null, this.$season$inlined, this.$episode$inlined, this.$subtitleCallback$inlined, this.$callback$inlined);
                                                        this.L$0 = semaphore3;
                                                        this.L$1 = obj2;
                                                        this.L$2 = SpillingKt.nullOutSpilledVariable(continuation);
                                                        this.L$3 = SpillingKt.nullOutSpilledVariable(element);
                                                        this.L$4 = SpillingKt.nullOutSpilledVariable(str);
                                                        this.L$5 = SpillingKt.nullOutSpilledVariable(document2);
                                                        this.L$6 = SpillingKt.nullOutSpilledVariable(strSubstringBefore$default);
                                                        this.L$7 = SpillingKt.nullOutSpilledVariable(iterableSelect2);
                                                        this.L$8 = SpillingKt.nullOutSpilledVariable(iterable2);
                                                        this.L$9 = SpillingKt.nullOutSpilledVariable(this);
                                                        this.L$10 = SpillingKt.nullOutSpilledVariable(iterable2);
                                                        this.I$0 = 7;
                                                        this.label = 5;
                                                        objCoroutineScope = CoroutineScopeKt.coroutineScope(c0184x5cf40513, this);
                                                        if (objCoroutineScope == coroutine_suspended) {
                                                            return coroutine_suspended;
                                                        }
                                                        continuation2 = continuation;
                                                        semaphore5 = semaphore3;
                                                        str2 = strSubstringBefore$default;
                                                        try {
                                                            Result.constructor-impl((List) objCoroutineScope);
                                                            semaphore6 = semaphore5;
                                                        } catch (Throwable th7) {
                                                            th = th7;
                                                            i2 = i;
                                                            semaphore4 = semaphore5;
                                                            try {
                                                                Result.Companion companion5 = Result.Companion;
                                                                Result.constructor-impl(ResultKt.createFailure(th));
                                                                i = i2;
                                                                semaphore6 = semaphore4;
                                                            } catch (Exception e5) {
                                                                e = e5;
                                                                obj3 = obj2;
                                                                r12 = semaphore4;
                                                            } catch (Throwable th8) {
                                                                th = th8;
                                                                r12 = semaphore4;
                                                                r12.release();
                                                                throw th;
                                                            }
                                                        }
                                                        r12 = semaphore6;
                                                        i2 = i;
                                                        obj3 = obj2;
                                                        r2 = r12;
                                                        unit2 = Unit.INSTANCE;
                                                        r2.release();
                                                        return unit2;
                                                    } catch (Throwable th9) {
                                                        th = th9;
                                                        i2 = i;
                                                        continuation2 = continuation;
                                                        semaphore4 = semaphore3;
                                                        str2 = strSubstringBefore$default;
                                                        Result.Companion companion6 = Result.Companion;
                                                        Result.constructor-impl(ResultKt.createFailure(th));
                                                        i = i2;
                                                        semaphore6 = semaphore4;
                                                        r12 = semaphore6;
                                                        i2 = i;
                                                        obj3 = obj2;
                                                        r2 = r12;
                                                        unit2 = Unit.INSTANCE;
                                                        r2.release();
                                                        return unit2;
                                                    }
                                                } catch (Throwable th10) {
                                                    th = th10;
                                                    i2 = i;
                                                    continuation2 = continuation;
                                                    semaphore4 = semaphore3;
                                                    str2 = strSubstringBefore$default;
                                                }
                                            }
                                        } catch (Exception e6) {
                                            e = e6;
                                            r12 = strSubstringBefore$default;
                                            obj3 = obj2;
                                            i2 = i;
                                        }
                                    } catch (Exception e7) {
                                        e = e7;
                                        unit = null;
                                        r12 = semaphore2;
                                        obj3 = obj2;
                                        i2 = i;
                                    }
                                } catch (Exception e8) {
                                    e = e8;
                                    unit = null;
                                }
                                r2.release();
                                return unit2;
                            } catch (Throwable th11) {
                                th = th11;
                                r12 = semaphore2;
                            }
                            Log.INSTANCE.e("safeMap", "Request failed for " + obj3 + ' ' + e);
                            r2 = r12;
                            unit2 = unit;
                        } catch (Exception e9) {
                            e = e9;
                            unit = null;
                            obj3 = obj2;
                            r12 = semaphore;
                            i2 = 0;
                        } catch (Throwable th12) {
                            th = th12;
                            r12 = semaphore;
                            r12.release();
                            throw th;
                        }
                        break;
                    case 1:
                        Object obj5 = this.L$1;
                        Semaphore semaphore8 = (Semaphore) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        c = 0;
                        semaphore = semaphore8;
                        obj2 = obj5;
                        i = 0;
                        Element element4 = (Element) obj2;
                        continuation = (Continuation) this;
                        i3 = 0;
                        strAttr = element4.attr("href");
                        this.L$0 = semaphore;
                        this.L$1 = obj2;
                        this.L$2 = SpillingKt.nullOutSpilledVariable(continuation);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(element4);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(strAttr);
                        this.label = 2;
                        element = element4;
                        objSafeGet$default = StreamPlayUtilsKt.safeGet$default(strAttr, null, null, null, null, false, 0, this, 126, null);
                        if (objSafeGet$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        semaphore2 = semaphore;
                        str = strAttr;
                        document = ((NiceResponse) objSafeGet$default).getDocument();
                        strSubstringBefore$default = StringsKt.substringBefore$default(StringsKt.substringAfter$default(document.select("p a:contains(IMDb Rating)").attr("href"), "title/", (String) null, 2, (Object) null), "/", (String) null, 2, (Object) null);
                        if (!Intrinsics.areEqual(strSubstringBefore$default, String.valueOf(this.$id$inlined))) {
                            unit2 = Unit.INSTANCE;
                            r2 = semaphore2;
                            r2.release();
                            return unit2;
                        }
                        if (this.$season$inlined == null) {
                            document2 = document;
                            unit = null;
                            semaphore3 = semaphore2;
                            Iterable iterableSelect3 = document2.select("div.downloads-btns-div");
                            Iterable iterable3 = iterableSelect3;
                            Result.Companion companion7 = Result.Companion;
                            C0184x5cf40513 c0184x5cf40514 = new C0184x5cf40513(7, iterable3, null, this.$season$inlined, this.$episode$inlined, this.$subtitleCallback$inlined, this.$callback$inlined);
                            this.L$0 = semaphore3;
                            this.L$1 = obj2;
                            this.L$2 = SpillingKt.nullOutSpilledVariable(continuation);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(element);
                            this.L$4 = SpillingKt.nullOutSpilledVariable(str);
                            this.L$5 = SpillingKt.nullOutSpilledVariable(document2);
                            this.L$6 = SpillingKt.nullOutSpilledVariable(strSubstringBefore$default);
                            this.L$7 = SpillingKt.nullOutSpilledVariable(iterableSelect3);
                            this.L$8 = SpillingKt.nullOutSpilledVariable(iterable3);
                            this.L$9 = SpillingKt.nullOutSpilledVariable(this);
                            this.L$10 = SpillingKt.nullOutSpilledVariable(iterable3);
                            this.I$0 = 7;
                            this.label = 5;
                            objCoroutineScope = CoroutineScopeKt.coroutineScope(c0184x5cf40514, this);
                            if (objCoroutineScope == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            continuation2 = continuation;
                            semaphore5 = semaphore3;
                            str2 = strSubstringBefore$default;
                            Result.constructor-impl((List) objCoroutineScope);
                            semaphore6 = semaphore5;
                            r12 = semaphore6;
                            i2 = i;
                            obj3 = obj2;
                            r2 = r12;
                            unit2 = Unit.INSTANCE;
                            r2.release();
                            return unit2;
                        }
                        strAttr2 = document.select("div.download-links-div a.btn").attr("href");
                        this.L$0 = semaphore2;
                        this.L$1 = obj2;
                        this.L$2 = SpillingKt.nullOutSpilledVariable(continuation);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(element);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(str);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(document);
                        this.L$6 = SpillingKt.nullOutSpilledVariable(strSubstringBefore$default);
                        this.L$7 = SpillingKt.nullOutSpilledVariable(strAttr2);
                        this.label = 3;
                        str3 = strSubstringBefore$default;
                        r11 = semaphore2;
                        unit = null;
                        objSafeGet$default2 = StreamPlayUtilsKt.safeGet$default(strAttr2, null, null, null, null, false, 0, this, 126, null);
                        if (objSafeGet$default2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        document3 = document;
                        i2 = i;
                        str4 = strAttr2;
                        continuation3 = continuation;
                        element2 = element;
                        Document document5 = ((NiceResponse) objSafeGet$default2).getDocument();
                        Iterable iterableSelect4 = document5.select("div.downloads-btns-div a.btn");
                        Iterable iterable4 = iterableSelect4;
                        Result.Companion companion8 = Result.Companion;
                        C0183x5cf40512 c0183x5cf40513 = new C0183x5cf40512(7, iterable4, null, this.$subtitleCallback$inlined, this.$callback$inlined);
                        this.L$0 = r11;
                        this.L$1 = obj2;
                        i4 = i2;
                        this.L$2 = SpillingKt.nullOutSpilledVariable(continuation3);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(element2);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(str);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(document3);
                        this.L$6 = SpillingKt.nullOutSpilledVariable(str3);
                        this.L$7 = SpillingKt.nullOutSpilledVariable(str4);
                        this.L$8 = SpillingKt.nullOutSpilledVariable(document5);
                        this.L$9 = SpillingKt.nullOutSpilledVariable(iterableSelect4);
                        this.L$10 = SpillingKt.nullOutSpilledVariable(iterable4);
                        this.L$11 = SpillingKt.nullOutSpilledVariable(this);
                        this.L$12 = SpillingKt.nullOutSpilledVariable(iterable4);
                        this.I$0 = 7;
                        this.label = 4;
                        objCoroutineScope2 = CoroutineScopeKt.coroutineScope(c0183x5cf40513, this);
                        if (objCoroutineScope2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        r20 = r11;
                        i2 = i4;
                        Result.constructor-impl((List) objCoroutineScope2);
                        r21 = r20;
                        r12 = r21;
                        obj3 = obj2;
                        r2 = r12;
                        unit2 = Unit.INSTANCE;
                        r2.release();
                        return unit2;
                        Log.INSTANCE.e("safeMap", "Request failed for " + obj3 + ' ' + e);
                        r2 = r12;
                        unit2 = unit;
                        r2.release();
                        return unit2;
                    case 2:
                        i2 = 0;
                        String str5 = (String) this.L$4;
                        Element element5 = (Element) this.L$3;
                        Continuation continuation4 = (Continuation) this.L$2;
                        Object obj6 = this.L$1;
                        Semaphore semaphore9 = (Semaphore) this.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            i3 = 0;
                            c = 0;
                            i = 0;
                            str = str5;
                            element = element5;
                            continuation = continuation4;
                            obj2 = obj6;
                            semaphore2 = semaphore9;
                            objSafeGet$default = obj;
                            document = ((NiceResponse) objSafeGet$default).getDocument();
                            strSubstringBefore$default = StringsKt.substringBefore$default(StringsKt.substringAfter$default(document.select("p a:contains(IMDb Rating)").attr("href"), "title/", (String) null, 2, (Object) null), "/", (String) null, 2, (Object) null);
                            if (!Intrinsics.areEqual(strSubstringBefore$default, String.valueOf(this.$id$inlined))) {
                                unit2 = Unit.INSTANCE;
                                r2 = semaphore2;
                                r2.release();
                                return unit2;
                            }
                            if (this.$season$inlined == null) {
                                document2 = document;
                                unit = null;
                                semaphore3 = semaphore2;
                                Iterable iterableSelect5 = document2.select("div.downloads-btns-div");
                                Iterable iterable5 = iterableSelect5;
                                Result.Companion companion9 = Result.Companion;
                                C0184x5cf40513 c0184x5cf40515 = new C0184x5cf40513(7, iterable5, null, this.$season$inlined, this.$episode$inlined, this.$subtitleCallback$inlined, this.$callback$inlined);
                                this.L$0 = semaphore3;
                                this.L$1 = obj2;
                                this.L$2 = SpillingKt.nullOutSpilledVariable(continuation);
                                this.L$3 = SpillingKt.nullOutSpilledVariable(element);
                                this.L$4 = SpillingKt.nullOutSpilledVariable(str);
                                this.L$5 = SpillingKt.nullOutSpilledVariable(document2);
                                this.L$6 = SpillingKt.nullOutSpilledVariable(strSubstringBefore$default);
                                this.L$7 = SpillingKt.nullOutSpilledVariable(iterableSelect5);
                                this.L$8 = SpillingKt.nullOutSpilledVariable(iterable5);
                                this.L$9 = SpillingKt.nullOutSpilledVariable(this);
                                this.L$10 = SpillingKt.nullOutSpilledVariable(iterable5);
                                this.I$0 = 7;
                                this.label = 5;
                                objCoroutineScope = CoroutineScopeKt.coroutineScope(c0184x5cf40515, this);
                                if (objCoroutineScope == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                continuation2 = continuation;
                                semaphore5 = semaphore3;
                                str2 = strSubstringBefore$default;
                                Result.constructor-impl((List) objCoroutineScope);
                                semaphore6 = semaphore5;
                                r12 = semaphore6;
                                i2 = i;
                                obj3 = obj2;
                                r2 = r12;
                                unit2 = Unit.INSTANCE;
                                r2.release();
                                return unit2;
                            }
                            strAttr2 = document.select("div.download-links-div a.btn").attr("href");
                            this.L$0 = semaphore2;
                            this.L$1 = obj2;
                            this.L$2 = SpillingKt.nullOutSpilledVariable(continuation);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(element);
                            this.L$4 = SpillingKt.nullOutSpilledVariable(str);
                            this.L$5 = SpillingKt.nullOutSpilledVariable(document);
                            this.L$6 = SpillingKt.nullOutSpilledVariable(strSubstringBefore$default);
                            this.L$7 = SpillingKt.nullOutSpilledVariable(strAttr2);
                            this.label = 3;
                            str3 = strSubstringBefore$default;
                            r11 = semaphore2;
                            unit = null;
                            objSafeGet$default2 = StreamPlayUtilsKt.safeGet$default(strAttr2, null, null, null, null, false, 0, this, 126, null);
                            if (objSafeGet$default2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            document3 = document;
                            i2 = i;
                            str4 = strAttr2;
                            continuation3 = continuation;
                            element2 = element;
                            Document document6 = ((NiceResponse) objSafeGet$default2).getDocument();
                            Iterable iterableSelect6 = document6.select("div.downloads-btns-div a.btn");
                            Iterable iterable6 = iterableSelect6;
                            Result.Companion companion10 = Result.Companion;
                            C0183x5cf40512 c0183x5cf40514 = new C0183x5cf40512(7, iterable6, null, this.$subtitleCallback$inlined, this.$callback$inlined);
                            this.L$0 = r11;
                            this.L$1 = obj2;
                            i4 = i2;
                            this.L$2 = SpillingKt.nullOutSpilledVariable(continuation3);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(element2);
                            this.L$4 = SpillingKt.nullOutSpilledVariable(str);
                            this.L$5 = SpillingKt.nullOutSpilledVariable(document3);
                            this.L$6 = SpillingKt.nullOutSpilledVariable(str3);
                            this.L$7 = SpillingKt.nullOutSpilledVariable(str4);
                            this.L$8 = SpillingKt.nullOutSpilledVariable(document6);
                            this.L$9 = SpillingKt.nullOutSpilledVariable(iterableSelect6);
                            this.L$10 = SpillingKt.nullOutSpilledVariable(iterable6);
                            this.L$11 = SpillingKt.nullOutSpilledVariable(this);
                            this.L$12 = SpillingKt.nullOutSpilledVariable(iterable6);
                            this.I$0 = 7;
                            this.label = 4;
                            objCoroutineScope2 = CoroutineScopeKt.coroutineScope(c0183x5cf40514, this);
                            if (objCoroutineScope2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            r20 = r11;
                            i2 = i4;
                            Result.constructor-impl((List) objCoroutineScope2);
                            r21 = r20;
                            r12 = r21;
                            obj3 = obj2;
                            r2 = r12;
                            unit2 = Unit.INSTANCE;
                            r2.release();
                            return unit2;
                        } catch (Exception e10) {
                            e = e10;
                            obj3 = obj6;
                            r12 = semaphore9;
                            unit = null;
                        } catch (Throwable th13) {
                            th = th13;
                            r12 = semaphore9;
                            r12.release();
                            throw th;
                        }
                        Log.INSTANCE.e("safeMap", "Request failed for " + obj3 + ' ' + e);
                        r2 = r12;
                        unit2 = unit;
                        r2.release();
                        return unit2;
                    case 3:
                        i2 = 0;
                        String str6 = (String) this.L$7;
                        String str7 = (String) this.L$6;
                        document3 = (Document) this.L$5;
                        String str8 = (String) this.L$4;
                        Element element6 = (Element) this.L$3;
                        Continuation continuation5 = (Continuation) this.L$2;
                        obj3 = this.L$1;
                        r12 = (Semaphore) this.L$0;
                        try {
                            try {
                                ResultKt.throwOnFailure(obj);
                                c = 0;
                                str3 = str7;
                                str = str8;
                                element2 = element6;
                                continuation3 = continuation5;
                                obj2 = obj3;
                                r11 = r12;
                                unit = null;
                                objSafeGet$default2 = obj;
                                str4 = str6;
                                Document document7 = ((NiceResponse) objSafeGet$default2).getDocument();
                                Iterable iterableSelect7 = document7.select("div.downloads-btns-div a.btn");
                                Iterable iterable7 = iterableSelect7;
                                Result.Companion companion11 = Result.Companion;
                                C0183x5cf40512 c0183x5cf40515 = new C0183x5cf40512(7, iterable7, null, this.$subtitleCallback$inlined, this.$callback$inlined);
                                this.L$0 = r11;
                                this.L$1 = obj2;
                                i4 = i2;
                                this.L$2 = SpillingKt.nullOutSpilledVariable(continuation3);
                                this.L$3 = SpillingKt.nullOutSpilledVariable(element2);
                                this.L$4 = SpillingKt.nullOutSpilledVariable(str);
                                this.L$5 = SpillingKt.nullOutSpilledVariable(document3);
                                this.L$6 = SpillingKt.nullOutSpilledVariable(str3);
                                this.L$7 = SpillingKt.nullOutSpilledVariable(str4);
                                this.L$8 = SpillingKt.nullOutSpilledVariable(document7);
                                this.L$9 = SpillingKt.nullOutSpilledVariable(iterableSelect7);
                                this.L$10 = SpillingKt.nullOutSpilledVariable(iterable7);
                                this.L$11 = SpillingKt.nullOutSpilledVariable(this);
                                this.L$12 = SpillingKt.nullOutSpilledVariable(iterable7);
                                this.I$0 = 7;
                                this.label = 4;
                                objCoroutineScope2 = CoroutineScopeKt.coroutineScope(c0183x5cf40515, this);
                                if (objCoroutineScope2 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                r20 = r11;
                                i2 = i4;
                                Result.constructor-impl((List) objCoroutineScope2);
                                r21 = r20;
                                r12 = r21;
                                obj3 = obj2;
                                r2 = r12;
                                unit2 = Unit.INSTANCE;
                                r2.release();
                                return unit2;
                            } catch (Throwable th14) {
                                th = th14;
                                r12.release();
                                throw th;
                            }
                        } catch (Exception e11) {
                            e = e11;
                            unit = null;
                            break;
                        }
                        break;
                    case 4:
                        i2 = 0;
                        int i5 = this.I$0;
                        Object obj7 = this.L$1;
                        Semaphore semaphore10 = (Semaphore) this.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            objCoroutineScope2 = obj;
                            obj2 = obj7;
                            r20 = semaphore10;
                            unit = null;
                            Result.constructor-impl((List) objCoroutineScope2);
                            r21 = r20;
                            break;
                        } catch (Throwable th15) {
                            th = th15;
                            obj2 = obj7;
                            r20 = semaphore10;
                            unit = null;
                            Result.Companion companion12 = Result.Companion;
                            Result.constructor-impl(ResultKt.createFailure(th));
                            r21 = r20;
                            r12 = r21;
                            obj3 = obj2;
                            r2 = r12;
                            unit2 = Unit.INSTANCE;
                            r2.release();
                            return unit2;
                        }
                        r12 = r21;
                        obj3 = obj2;
                        r2 = r12;
                        unit2 = Unit.INSTANCE;
                        r2.release();
                        return unit2;
                    case 5:
                        i2 = 0;
                        int i6 = this.I$0;
                        str2 = (String) this.L$6;
                        document2 = (Document) this.L$5;
                        String str9 = (String) this.L$4;
                        Element element7 = (Element) this.L$3;
                        continuation2 = (Continuation) this.L$2;
                        Object obj8 = this.L$1;
                        Semaphore semaphore11 = (Semaphore) this.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            element = element7;
                            unit = null;
                            str = str9;
                            obj2 = obj8;
                            i = 0;
                            objCoroutineScope = obj;
                            semaphore5 = semaphore11;
                            Result.constructor-impl((List) objCoroutineScope);
                            semaphore6 = semaphore5;
                        } catch (Throwable th16) {
                            th = th16;
                            element = element7;
                            unit = null;
                            str = str9;
                            obj2 = obj8;
                            semaphore4 = semaphore11;
                            Result.Companion companion13 = Result.Companion;
                            Result.constructor-impl(ResultKt.createFailure(th));
                            i = i2;
                            semaphore6 = semaphore4;
                            r12 = semaphore6;
                            i2 = i;
                            obj3 = obj2;
                            r2 = r12;
                            unit2 = Unit.INSTANCE;
                            r2.release();
                            return unit2;
                        }
                        r12 = semaphore6;
                        i2 = i;
                        obj3 = obj2;
                        r2 = r12;
                        unit2 = Unit.INSTANCE;
                        r2.release();
                        return unit2;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Throwable th17) {
                th = th17;
                r12 = 2;
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
                    destination$iv$iv2.add(BuildersKt.async$default($this$coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new C01811(semaphore, item$iv$iv, null, this.$id$inlined, this.$season$inlined, this.$subtitleCallback$inlined, this.$callback$inlined, this.$episode$inlined), 2, (Object) null));
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
