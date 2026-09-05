package com.phisher98;

import com.lagradost.api.Log;
import com.lagradost.nicehttp.NiceResponse;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
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
import kotlin.jvm.internal.SourceDebugExtension;
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

/* JADX INFO: renamed from: com.phisher98.StreamPlayExtractor$invokeHindmoviez$lambda$1$$inlined$safeAmap$default$2 */
/* JADX INFO: compiled from: StreamPlayUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeHindmoviez$lambda$1$$inlined$safeAmap$default$2", f = "StreamPlayExtractor.kt", i = {0, 0}, l = {1898}, m = "invokeSuspend", n = {"$this$coroutineScope", "semaphore"}, nl = {-1}, s = {"L$0", "L$1"}, v = 2)
@SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,2265:1\n1739#2:2266\n1814#2,3:2267\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1\n*L\n1887#1:2266\n1887#1:2267,3\n*E\n"})
public final class C0165x3343ef77 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Unit>>, Object> {
    final /* synthetic */ Function1 $callback$inlined;
    final /* synthetic */ int $concurrency;
    final /* synthetic */ Integer $episode$inlined;
    final /* synthetic */ Integer $season$inlined;
    final /* synthetic */ Function1 $subtitleCallback$inlined;
    final /* synthetic */ Iterable $this_runCatching;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0165x3343ef77(int i, Iterable iterable, Continuation continuation, Integer num, Integer num2, Function1 function1, Function1 function2) {
        super(2, continuation);
        this.$concurrency = i;
        this.$this_runCatching = iterable;
        this.$season$inlined = num;
        this.$episode$inlined = num2;
        this.$subtitleCallback$inlined = function1;
        this.$callback$inlined = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> c0165x3343ef77 = new C0165x3343ef77(this.$concurrency, this.$this_runCatching, continuation, this.$season$inlined, this.$episode$inlined, this.$subtitleCallback$inlined, this.$callback$inlined);
        c0165x3343ef77.L$0 = obj;
        return c0165x3343ef77;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Unit>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.phisher98.StreamPlayExtractor$invokeHindmoviez$lambda$1$$inlined$safeAmap$default$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: StreamPlayUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "B", "Lkotlinx/coroutines/CoroutineScope;", "com/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StreamPlayExtractor$invokeHindmoviez$lambda$1$$inlined$safeAmap$default$2$1", f = "StreamPlayExtractor.kt", i = {0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3}, l = {2266, 2280, 2293, 2297}, m = "invokeSuspend", n = {"$this$withPermit$iv", "$this$withPermit$iv", "$completion", "btn", "headerText", "$this$withPermit$iv", "$completion", "btn", "episodeDoc", "headerText", "href", "baseurl", "rawId", "$this$withPermit$iv", "$completion", "btn", "episodeDoc", "episodeLink", "headerText"}, nl = {2267, 2281, 2286, 2298}, s = {"L$0", "L$0", "L$2", "L$3", "L$4", "L$0", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$2", "L$3", "L$4", "L$5", "L$6"}, v = 2)
    @SourceDebugExtension({"SMAP\nStreamPlayUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n+ 2 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreKt\n+ 3 StreamPlayExtractor.kt\ncom/phisher98/StreamPlayExtractor\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,2265:1\n81#2,3:2266\n85#2,2:2299\n4615#3,3:2269\n4614#3,15:2272\n4629#3,11:2288\n1#4:2287\n*S KotlinDebug\n*F\n+ 1 StreamPlayUtils.kt\ncom/phisher98/StreamPlayUtilsKt$safeAmap$2$1$1$1\n*L\n1889#1:2266,3\n1889#1:2299,2\n*E\n"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1 $callback$inlined;
        final /* synthetic */ Integer $episode$inlined;
        final /* synthetic */ Object $item;
        final /* synthetic */ Integer $season$inlined;
        final /* synthetic */ Semaphore $semaphore;
        final /* synthetic */ Function1 $subtitleCallback$inlined;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Semaphore semaphore, Object obj, Continuation continuation, Integer num, Integer num2, Function1 function1, Function1 function2) {
            super(2, continuation);
            this.$semaphore = semaphore;
            this.$item = obj;
            this.$season$inlined = num;
            this.$episode$inlined = num2;
            this.$subtitleCallback$inlined = function1;
            this.$callback$inlined = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$semaphore, this.$item, continuation, this.$season$inlined, this.$episode$inlined, this.$subtitleCallback$inlined, this.$callback$inlined);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:100:0x00de A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:44:0x00fe  */
        /* JADX WARN: Code duplicated, block: B:46:0x0101  */
        /* JADX WARN: Code duplicated, block: B:50:0x0126 A[Catch: all -> 0x00f1, Exception -> 0x00f6, TRY_ENTER, TRY_LEAVE, TryCatch #11 {Exception -> 0x00f6, all -> 0x00f1, blocks: (B:35:0x00de, B:37:0x00e5, B:39:0x00ec, B:50:0x0126), top: B:100:0x00de }] */
        /* JADX WARN: Code duplicated, block: B:52:0x012b A[Catch: all -> 0x027f, Exception -> 0x0286, TRY_ENTER, TRY_LEAVE, TryCatch #8 {Exception -> 0x0286, all -> 0x027f, blocks: (B:33:0x00ca, B:48:0x0105, B:52:0x012b), top: B:106:0x00ca }] */
        /* JADX WARN: Code duplicated, block: B:56:0x0166 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:57:0x0167  */
        /* JADX WARN: Code duplicated, block: B:60:0x0196 A[Catch: all -> 0x0098, Exception -> 0x009c, TryCatch #9 {Exception -> 0x009c, all -> 0x0098, blocks: (B:21:0x008f, B:58:0x0174, B:60:0x0196, B:62:0x019d, B:67:0x01ae), top: B:104:0x008f }] */
        /* JADX WARN: Code duplicated, block: B:64:0x01a8  */
        /* JADX WARN: Code duplicated, block: B:65:0x01a9  */
        /* JADX WARN: Code duplicated, block: B:67:0x01ae A[Catch: all -> 0x0098, Exception -> 0x009c, TRY_LEAVE, TryCatch #9 {Exception -> 0x009c, all -> 0x0098, blocks: (B:21:0x008f, B:58:0x0174, B:60:0x0196, B:62:0x019d, B:67:0x01ae), top: B:104:0x008f }] */
        /* JADX WARN: Code duplicated, block: B:69:0x0206 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:70:0x0207  */
        /* JADX WARN: Code duplicated, block: B:73:0x021a A[Catch: all -> 0x0071, Exception -> 0x0075, TRY_LEAVE, TryCatch #10 {Exception -> 0x0075, all -> 0x0071, blocks: (B:14:0x006a, B:71:0x0215, B:73:0x021a), top: B:102:0x006a }] */
        /* JADX WARN: Code duplicated, block: B:75:0x0252 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:76:0x0253  */
        /* JADX WARN: Code duplicated, block: B:78:0x025f  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r10v1, types: [kotlinx.coroutines.sync.Semaphore] */
        /* JADX WARN: Type inference failed for: r10v10 */
        /* JADX WARN: Type inference failed for: r10v12 */
        /* JADX WARN: Type inference failed for: r10v13 */
        /* JADX WARN: Type inference failed for: r10v2 */
        /* JADX WARN: Type inference failed for: r10v3 */
        /* JADX WARN: Type inference failed for: r10v4 */
        /* JADX WARN: Type inference failed for: r10v5 */
        /* JADX WARN: Type inference failed for: r10v6 */
        /* JADX WARN: Type inference failed for: r10v7 */
        /* JADX WARN: Type inference failed for: r10v8 */
        /* JADX WARN: Type inference failed for: r10v9 */
        /* JADX WARN: Type inference failed for: r2v1 */
        /* JADX WARN: Type inference failed for: r2v18 */
        /* JADX WARN: Type inference failed for: r2v2, types: [kotlinx.coroutines.sync.Semaphore] */
        /* JADX WARN: Type inference failed for: r2v22 */
        /* JADX WARN: Type inference failed for: r2v24 */
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object obj2;
            int i;
            int i2;
            ?? r2;
            Object obj3;
            Object obj4;
            int i3;
            Semaphore semaphore;
            Continuation continuation;
            Element element;
            int i4;
            Element elementParent;
            Element elementParent2;
            Element elementPreviousElementSibling;
            String strText;
            String str;
            Object obj5;
            Semaphore semaphore2;
            Object objSafeGet$default;
            Continuation continuation2;
            String str2;
            Semaphore semaphore3;
            Element element2;
            Document document;
            Element element3;
            Semaphore semaphore4;
            String strAttr;
            Object objHindmoviezsignHShare;
            Object obj6;
            Semaphore semaphore5;
            String str3;
            Element element4;
            Continuation continuation3;
            Object obj7;
            Document document2;
            int i5;
            String str4;
            Object hindMoviezLinks;
            Semaphore semaphore6;
            Object obj8;
            ?? coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                try {
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure(obj);
                            Semaphore semaphore7 = this.$semaphore;
                            obj4 = this.$item;
                            this.L$0 = semaphore7;
                            this.L$1 = obj4;
                            this.label = 1;
                            if (semaphore7.acquire((Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            i3 = 0;
                            semaphore = semaphore7;
                            try {
                                continuation = (Continuation) this;
                                element = (Element) obj4;
                                i4 = 0;
                                elementParent = element.parent();
                                if (elementParent != null) {
                                    try {
                                        elementParent2 = elementParent.parent();
                                        if (elementParent2 != null || (elementPreviousElementSibling = elementParent2.previousElementSibling()) == null) {
                                            strText = null;
                                        } else {
                                            strText = elementPreviousElementSibling.text();
                                        }
                                        if (strText == null) {
                                            strText = "";
                                        }
                                        str = strText;
                                        if (StringsKt.contains(str, "Season " + this.$season$inlined, true)) {
                                            String strAttr2 = element.attr("href");
                                            Long lBoxLong = Boxing.boxLong(5000L);
                                            this.L$0 = semaphore;
                                            this.L$1 = obj4;
                                            this.L$2 = SpillingKt.nullOutSpilledVariable(continuation);
                                            this.L$3 = SpillingKt.nullOutSpilledVariable(element);
                                            this.L$4 = SpillingKt.nullOutSpilledVariable(str);
                                            this.label = 2;
                                            obj5 = obj4;
                                            semaphore2 = semaphore;
                                            try {
                                                objSafeGet$default = StreamPlayUtilsKt.safeGet$default(strAttr2, null, null, lBoxLong, null, false, 0, this, 118, null);
                                                if (objSafeGet$default == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                i2 = i3;
                                                i = 0;
                                                continuation2 = continuation;
                                                str2 = str;
                                                semaphore3 = semaphore2;
                                                element2 = element;
                                                obj2 = obj5;
                                                document = ((NiceResponse) objSafeGet$default).getDocument();
                                                element3 = (Element) CollectionsKt.getOrNull(document.select("h3 > a"), this.$episode$inlined.intValue() - 1);
                                                if (element3 != null && (strAttr = element3.attr("href")) != null) {
                                                    if (StringsKt.isBlank(strAttr)) {
                                                        strAttr = null;
                                                    }
                                                    if (strAttr != null) {
                                                        String strSubstringBefore$default = StringsKt.substringBefore$default(strAttr, "/?id=", (String) null, 2, (Object) null);
                                                        String strDecode = URLDecoder.decode(StringsKt.replace$default(StringsKt.substringAfter$default(strAttr, "id=", (String) null, 2, (Object) null), "+", "%2B", false, 4, (Object) null), "UTF-8");
                                                        this.L$0 = semaphore3;
                                                        this.L$1 = obj2;
                                                        this.L$2 = SpillingKt.nullOutSpilledVariable(continuation2);
                                                        this.L$3 = SpillingKt.nullOutSpilledVariable(element2);
                                                        this.L$4 = SpillingKt.nullOutSpilledVariable(document);
                                                        this.L$5 = SpillingKt.nullOutSpilledVariable(str2);
                                                        this.L$6 = SpillingKt.nullOutSpilledVariable(strAttr);
                                                        this.L$7 = SpillingKt.nullOutSpilledVariable(strSubstringBefore$default);
                                                        this.L$8 = SpillingKt.nullOutSpilledVariable(strDecode);
                                                        this.label = 3;
                                                        objHindmoviezsignHShare = StreamPlayUtilsKt.hindmoviezsignHShare(strDecode, strSubstringBefore$default, document, this);
                                                        if (objHindmoviezsignHShare == coroutine_suspended) {
                                                            return coroutine_suspended;
                                                        }
                                                        obj6 = objHindmoviezsignHShare;
                                                        semaphore5 = semaphore3;
                                                        str3 = str2;
                                                        element4 = element2;
                                                        continuation3 = continuation2;
                                                        obj7 = obj2;
                                                        document2 = document;
                                                        i5 = i4;
                                                        str4 = (String) obj6;
                                                        if (str4 == null) {
                                                            Function1 function1 = this.$subtitleCallback$inlined;
                                                            Function1 function2 = this.$callback$inlined;
                                                            this.L$0 = semaphore5;
                                                            this.L$1 = obj7;
                                                            this.L$2 = SpillingKt.nullOutSpilledVariable(continuation3);
                                                            this.L$3 = SpillingKt.nullOutSpilledVariable(element4);
                                                            this.L$4 = SpillingKt.nullOutSpilledVariable(document2);
                                                            this.L$5 = SpillingKt.nullOutSpilledVariable(str4);
                                                            this.L$6 = SpillingKt.nullOutSpilledVariable(str3);
                                                            this.L$7 = null;
                                                            this.L$8 = null;
                                                            this.label = 4;
                                                            hindMoviezLinks = StreamPlayUtilsKt.getHindMoviezLinks("Hindmoviez", str4, function1, function2, this);
                                                            if (hindMoviezLinks == coroutine_suspended) {
                                                                return coroutine_suspended;
                                                            }
                                                            semaphore6 = semaphore5;
                                                            obj8 = hindMoviezLinks;
                                                            obj3 = obj8;
                                                            r2 = semaphore6;
                                                        } else {
                                                            semaphore4 = semaphore5;
                                                        }
                                                    }
                                                    obj3 = Unit.INSTANCE;
                                                    r2 = semaphore4;
                                                }
                                                semaphore4 = semaphore3;
                                                obj3 = Unit.INSTANCE;
                                                r2 = semaphore4;
                                            } catch (Exception e) {
                                                e = e;
                                                i2 = i3;
                                                i = 0;
                                                coroutine_suspended = semaphore2;
                                                obj2 = obj5;
                                                Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                                                r2 = coroutine_suspended;
                                                obj3 = null;
                                            } catch (Throwable th) {
                                                th = th;
                                                coroutine_suspended = semaphore2;
                                                coroutine_suspended.release();
                                                throw th;
                                            }
                                        } else {
                                            obj3 = Unit.INSTANCE;
                                            r2 = semaphore;
                                        }
                                    } catch (Exception e2) {
                                        e = e2;
                                        obj2 = obj4;
                                        coroutine_suspended = semaphore;
                                        i2 = i3;
                                        i = 0;
                                        Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                                        r2 = coroutine_suspended;
                                        obj3 = null;
                                        r2.release();
                                        return obj3;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        coroutine_suspended = semaphore;
                                        coroutine_suspended.release();
                                        throw th;
                                    }
                                } else {
                                    strText = null;
                                    if (strText == null) {
                                        strText = "";
                                    }
                                    str = strText;
                                    if (StringsKt.contains(str, "Season " + this.$season$inlined, true)) {
                                        obj3 = Unit.INSTANCE;
                                        r2 = semaphore;
                                    } else {
                                        String strAttr3 = element.attr("href");
                                        Long lBoxLong2 = Boxing.boxLong(5000L);
                                        this.L$0 = semaphore;
                                        this.L$1 = obj4;
                                        this.L$2 = SpillingKt.nullOutSpilledVariable(continuation);
                                        this.L$3 = SpillingKt.nullOutSpilledVariable(element);
                                        this.L$4 = SpillingKt.nullOutSpilledVariable(str);
                                        this.label = 2;
                                        obj5 = obj4;
                                        semaphore2 = semaphore;
                                        objSafeGet$default = StreamPlayUtilsKt.safeGet$default(strAttr3, null, null, lBoxLong2, null, false, 0, this, 118, null);
                                        if (objSafeGet$default == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        i2 = i3;
                                        i = 0;
                                        continuation2 = continuation;
                                        str2 = str;
                                        semaphore3 = semaphore2;
                                        element2 = element;
                                        obj2 = obj5;
                                        document = ((NiceResponse) objSafeGet$default).getDocument();
                                        element3 = (Element) CollectionsKt.getOrNull(document.select("h3 > a"), this.$episode$inlined.intValue() - 1);
                                        if (element3 != null) {
                                            if (StringsKt.isBlank(strAttr)) {
                                                strAttr = null;
                                            }
                                            if (strAttr != null) {
                                                String strSubstringBefore$default2 = StringsKt.substringBefore$default(strAttr, "/?id=", (String) null, 2, (Object) null);
                                                String strDecode2 = URLDecoder.decode(StringsKt.replace$default(StringsKt.substringAfter$default(strAttr, "id=", (String) null, 2, (Object) null), "+", "%2B", false, 4, (Object) null), "UTF-8");
                                                this.L$0 = semaphore3;
                                                this.L$1 = obj2;
                                                this.L$2 = SpillingKt.nullOutSpilledVariable(continuation2);
                                                this.L$3 = SpillingKt.nullOutSpilledVariable(element2);
                                                this.L$4 = SpillingKt.nullOutSpilledVariable(document);
                                                this.L$5 = SpillingKt.nullOutSpilledVariable(str2);
                                                this.L$6 = SpillingKt.nullOutSpilledVariable(strAttr);
                                                this.L$7 = SpillingKt.nullOutSpilledVariable(strSubstringBefore$default2);
                                                this.L$8 = SpillingKt.nullOutSpilledVariable(strDecode2);
                                                this.label = 3;
                                                objHindmoviezsignHShare = StreamPlayUtilsKt.hindmoviezsignHShare(strDecode2, strSubstringBefore$default2, document, this);
                                                if (objHindmoviezsignHShare == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                obj6 = objHindmoviezsignHShare;
                                                semaphore5 = semaphore3;
                                                str3 = str2;
                                                element4 = element2;
                                                continuation3 = continuation2;
                                                obj7 = obj2;
                                                document2 = document;
                                                i5 = i4;
                                                str4 = (String) obj6;
                                                if (str4 == null) {
                                                    Function1 function3 = this.$subtitleCallback$inlined;
                                                    Function1 function4 = this.$callback$inlined;
                                                    this.L$0 = semaphore5;
                                                    this.L$1 = obj7;
                                                    this.L$2 = SpillingKt.nullOutSpilledVariable(continuation3);
                                                    this.L$3 = SpillingKt.nullOutSpilledVariable(element4);
                                                    this.L$4 = SpillingKt.nullOutSpilledVariable(document2);
                                                    this.L$5 = SpillingKt.nullOutSpilledVariable(str4);
                                                    this.L$6 = SpillingKt.nullOutSpilledVariable(str3);
                                                    this.L$7 = null;
                                                    this.L$8 = null;
                                                    this.label = 4;
                                                    hindMoviezLinks = StreamPlayUtilsKt.getHindMoviezLinks("Hindmoviez", str4, function3, function4, this);
                                                    if (hindMoviezLinks == coroutine_suspended) {
                                                        return coroutine_suspended;
                                                    }
                                                    semaphore6 = semaphore5;
                                                    obj8 = hindMoviezLinks;
                                                    obj3 = obj8;
                                                    r2 = semaphore6;
                                                } else {
                                                    semaphore4 = semaphore5;
                                                }
                                            }
                                            obj3 = Unit.INSTANCE;
                                            r2 = semaphore4;
                                        }
                                        semaphore4 = semaphore3;
                                        obj3 = Unit.INSTANCE;
                                        r2 = semaphore4;
                                    }
                                }
                            } catch (Exception e3) {
                                e = e3;
                                Object obj9 = obj4;
                                Semaphore semaphore8 = semaphore;
                                i2 = i3;
                                i = 0;
                                coroutine_suspended = semaphore8;
                                obj2 = obj9;
                            } catch (Throwable th3) {
                                th = th3;
                                coroutine_suspended = semaphore;
                            }
                            r2.release();
                            return obj3;
                        case 1:
                            obj4 = this.L$1;
                            Semaphore semaphore9 = (Semaphore) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            i3 = 0;
                            semaphore = semaphore9;
                            continuation = (Continuation) this;
                            element = (Element) obj4;
                            i4 = 0;
                            elementParent = element.parent();
                            if (elementParent != null) {
                                elementParent2 = elementParent.parent();
                                if (elementParent2 != null) {
                                    strText = null;
                                } else {
                                    strText = null;
                                }
                                if (strText == null) {
                                    strText = "";
                                }
                                str = strText;
                                if (StringsKt.contains(str, "Season " + this.$season$inlined, true)) {
                                    obj3 = Unit.INSTANCE;
                                    r2 = semaphore;
                                } else {
                                    String strAttr4 = element.attr("href");
                                    Long lBoxLong3 = Boxing.boxLong(5000L);
                                    this.L$0 = semaphore;
                                    this.L$1 = obj4;
                                    this.L$2 = SpillingKt.nullOutSpilledVariable(continuation);
                                    this.L$3 = SpillingKt.nullOutSpilledVariable(element);
                                    this.L$4 = SpillingKt.nullOutSpilledVariable(str);
                                    this.label = 2;
                                    obj5 = obj4;
                                    semaphore2 = semaphore;
                                    objSafeGet$default = StreamPlayUtilsKt.safeGet$default(strAttr4, null, null, lBoxLong3, null, false, 0, this, 118, null);
                                    if (objSafeGet$default == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    i2 = i3;
                                    i = 0;
                                    continuation2 = continuation;
                                    str2 = str;
                                    semaphore3 = semaphore2;
                                    element2 = element;
                                    obj2 = obj5;
                                    document = ((NiceResponse) objSafeGet$default).getDocument();
                                    element3 = (Element) CollectionsKt.getOrNull(document.select("h3 > a"), this.$episode$inlined.intValue() - 1);
                                    if (element3 != null) {
                                        if (StringsKt.isBlank(strAttr)) {
                                            strAttr = null;
                                        }
                                        if (strAttr != null) {
                                            String strSubstringBefore$default3 = StringsKt.substringBefore$default(strAttr, "/?id=", (String) null, 2, (Object) null);
                                            String strDecode3 = URLDecoder.decode(StringsKt.replace$default(StringsKt.substringAfter$default(strAttr, "id=", (String) null, 2, (Object) null), "+", "%2B", false, 4, (Object) null), "UTF-8");
                                            this.L$0 = semaphore3;
                                            this.L$1 = obj2;
                                            this.L$2 = SpillingKt.nullOutSpilledVariable(continuation2);
                                            this.L$3 = SpillingKt.nullOutSpilledVariable(element2);
                                            this.L$4 = SpillingKt.nullOutSpilledVariable(document);
                                            this.L$5 = SpillingKt.nullOutSpilledVariable(str2);
                                            this.L$6 = SpillingKt.nullOutSpilledVariable(strAttr);
                                            this.L$7 = SpillingKt.nullOutSpilledVariable(strSubstringBefore$default3);
                                            this.L$8 = SpillingKt.nullOutSpilledVariable(strDecode3);
                                            this.label = 3;
                                            objHindmoviezsignHShare = StreamPlayUtilsKt.hindmoviezsignHShare(strDecode3, strSubstringBefore$default3, document, this);
                                            if (objHindmoviezsignHShare == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            obj6 = objHindmoviezsignHShare;
                                            semaphore5 = semaphore3;
                                            str3 = str2;
                                            element4 = element2;
                                            continuation3 = continuation2;
                                            obj7 = obj2;
                                            document2 = document;
                                            i5 = i4;
                                            str4 = (String) obj6;
                                            if (str4 == null) {
                                                Function1 function5 = this.$subtitleCallback$inlined;
                                                Function1 function6 = this.$callback$inlined;
                                                this.L$0 = semaphore5;
                                                this.L$1 = obj7;
                                                this.L$2 = SpillingKt.nullOutSpilledVariable(continuation3);
                                                this.L$3 = SpillingKt.nullOutSpilledVariable(element4);
                                                this.L$4 = SpillingKt.nullOutSpilledVariable(document2);
                                                this.L$5 = SpillingKt.nullOutSpilledVariable(str4);
                                                this.L$6 = SpillingKt.nullOutSpilledVariable(str3);
                                                this.L$7 = null;
                                                this.L$8 = null;
                                                this.label = 4;
                                                hindMoviezLinks = StreamPlayUtilsKt.getHindMoviezLinks("Hindmoviez", str4, function5, function6, this);
                                                if (hindMoviezLinks == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                semaphore6 = semaphore5;
                                                obj8 = hindMoviezLinks;
                                                obj3 = obj8;
                                                r2 = semaphore6;
                                            } else {
                                                semaphore4 = semaphore5;
                                            }
                                        }
                                        obj3 = Unit.INSTANCE;
                                        r2 = semaphore4;
                                    }
                                    semaphore4 = semaphore3;
                                    obj3 = Unit.INSTANCE;
                                    r2 = semaphore4;
                                }
                            } else {
                                strText = null;
                                if (strText == null) {
                                    strText = "";
                                }
                                str = strText;
                                if (StringsKt.contains(str, "Season " + this.$season$inlined, true)) {
                                    obj3 = Unit.INSTANCE;
                                    r2 = semaphore;
                                } else {
                                    String strAttr5 = element.attr("href");
                                    Long lBoxLong4 = Boxing.boxLong(5000L);
                                    this.L$0 = semaphore;
                                    this.L$1 = obj4;
                                    this.L$2 = SpillingKt.nullOutSpilledVariable(continuation);
                                    this.L$3 = SpillingKt.nullOutSpilledVariable(element);
                                    this.L$4 = SpillingKt.nullOutSpilledVariable(str);
                                    this.label = 2;
                                    obj5 = obj4;
                                    semaphore2 = semaphore;
                                    objSafeGet$default = StreamPlayUtilsKt.safeGet$default(strAttr5, null, null, lBoxLong4, null, false, 0, this, 118, null);
                                    if (objSafeGet$default == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    i2 = i3;
                                    i = 0;
                                    continuation2 = continuation;
                                    str2 = str;
                                    semaphore3 = semaphore2;
                                    element2 = element;
                                    obj2 = obj5;
                                    document = ((NiceResponse) objSafeGet$default).getDocument();
                                    element3 = (Element) CollectionsKt.getOrNull(document.select("h3 > a"), this.$episode$inlined.intValue() - 1);
                                    if (element3 != null) {
                                        if (StringsKt.isBlank(strAttr)) {
                                            strAttr = null;
                                        }
                                        if (strAttr != null) {
                                            String strSubstringBefore$default4 = StringsKt.substringBefore$default(strAttr, "/?id=", (String) null, 2, (Object) null);
                                            String strDecode4 = URLDecoder.decode(StringsKt.replace$default(StringsKt.substringAfter$default(strAttr, "id=", (String) null, 2, (Object) null), "+", "%2B", false, 4, (Object) null), "UTF-8");
                                            this.L$0 = semaphore3;
                                            this.L$1 = obj2;
                                            this.L$2 = SpillingKt.nullOutSpilledVariable(continuation2);
                                            this.L$3 = SpillingKt.nullOutSpilledVariable(element2);
                                            this.L$4 = SpillingKt.nullOutSpilledVariable(document);
                                            this.L$5 = SpillingKt.nullOutSpilledVariable(str2);
                                            this.L$6 = SpillingKt.nullOutSpilledVariable(strAttr);
                                            this.L$7 = SpillingKt.nullOutSpilledVariable(strSubstringBefore$default4);
                                            this.L$8 = SpillingKt.nullOutSpilledVariable(strDecode4);
                                            this.label = 3;
                                            objHindmoviezsignHShare = StreamPlayUtilsKt.hindmoviezsignHShare(strDecode4, strSubstringBefore$default4, document, this);
                                            if (objHindmoviezsignHShare == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            obj6 = objHindmoviezsignHShare;
                                            semaphore5 = semaphore3;
                                            str3 = str2;
                                            element4 = element2;
                                            continuation3 = continuation2;
                                            obj7 = obj2;
                                            document2 = document;
                                            i5 = i4;
                                            str4 = (String) obj6;
                                            if (str4 == null) {
                                                Function1 function7 = this.$subtitleCallback$inlined;
                                                Function1 function8 = this.$callback$inlined;
                                                this.L$0 = semaphore5;
                                                this.L$1 = obj7;
                                                this.L$2 = SpillingKt.nullOutSpilledVariable(continuation3);
                                                this.L$3 = SpillingKt.nullOutSpilledVariable(element4);
                                                this.L$4 = SpillingKt.nullOutSpilledVariable(document2);
                                                this.L$5 = SpillingKt.nullOutSpilledVariable(str4);
                                                this.L$6 = SpillingKt.nullOutSpilledVariable(str3);
                                                this.L$7 = null;
                                                this.L$8 = null;
                                                this.label = 4;
                                                hindMoviezLinks = StreamPlayUtilsKt.getHindMoviezLinks("Hindmoviez", str4, function7, function8, this);
                                                if (hindMoviezLinks == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                semaphore6 = semaphore5;
                                                obj8 = hindMoviezLinks;
                                                obj3 = obj8;
                                                r2 = semaphore6;
                                            } else {
                                                semaphore4 = semaphore5;
                                            }
                                        }
                                        obj3 = Unit.INSTANCE;
                                        r2 = semaphore4;
                                    }
                                    semaphore4 = semaphore3;
                                    obj3 = Unit.INSTANCE;
                                    r2 = semaphore4;
                                }
                            }
                            r2.release();
                            return obj3;
                        case 2:
                            i2 = 0;
                            i = 0;
                            str2 = (String) this.L$4;
                            element2 = (Element) this.L$3;
                            continuation2 = (Continuation) this.L$2;
                            obj2 = this.L$1;
                            semaphore3 = (Semaphore) this.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                i4 = 0;
                                objSafeGet$default = obj;
                                semaphore3 = semaphore3;
                                document = ((NiceResponse) objSafeGet$default).getDocument();
                                element3 = (Element) CollectionsKt.getOrNull(document.select("h3 > a"), this.$episode$inlined.intValue() - 1);
                                if (element3 != null) {
                                    if (StringsKt.isBlank(strAttr)) {
                                        strAttr = null;
                                    }
                                    if (strAttr != null) {
                                        String strSubstringBefore$default5 = StringsKt.substringBefore$default(strAttr, "/?id=", (String) null, 2, (Object) null);
                                        String strDecode5 = URLDecoder.decode(StringsKt.replace$default(StringsKt.substringAfter$default(strAttr, "id=", (String) null, 2, (Object) null), "+", "%2B", false, 4, (Object) null), "UTF-8");
                                        this.L$0 = semaphore3;
                                        this.L$1 = obj2;
                                        this.L$2 = SpillingKt.nullOutSpilledVariable(continuation2);
                                        this.L$3 = SpillingKt.nullOutSpilledVariable(element2);
                                        this.L$4 = SpillingKt.nullOutSpilledVariable(document);
                                        this.L$5 = SpillingKt.nullOutSpilledVariable(str2);
                                        this.L$6 = SpillingKt.nullOutSpilledVariable(strAttr);
                                        this.L$7 = SpillingKt.nullOutSpilledVariable(strSubstringBefore$default5);
                                        this.L$8 = SpillingKt.nullOutSpilledVariable(strDecode5);
                                        this.label = 3;
                                        objHindmoviezsignHShare = StreamPlayUtilsKt.hindmoviezsignHShare(strDecode5, strSubstringBefore$default5, document, this);
                                        if (objHindmoviezsignHShare == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        obj6 = objHindmoviezsignHShare;
                                        semaphore5 = semaphore3;
                                        str3 = str2;
                                        element4 = element2;
                                        continuation3 = continuation2;
                                        obj7 = obj2;
                                        document2 = document;
                                        i5 = i4;
                                        str4 = (String) obj6;
                                        if (str4 == null) {
                                            Function1 function9 = this.$subtitleCallback$inlined;
                                            Function1 function10 = this.$callback$inlined;
                                            this.L$0 = semaphore5;
                                            this.L$1 = obj7;
                                            this.L$2 = SpillingKt.nullOutSpilledVariable(continuation3);
                                            this.L$3 = SpillingKt.nullOutSpilledVariable(element4);
                                            this.L$4 = SpillingKt.nullOutSpilledVariable(document2);
                                            this.L$5 = SpillingKt.nullOutSpilledVariable(str4);
                                            this.L$6 = SpillingKt.nullOutSpilledVariable(str3);
                                            this.L$7 = null;
                                            this.L$8 = null;
                                            this.label = 4;
                                            hindMoviezLinks = StreamPlayUtilsKt.getHindMoviezLinks("Hindmoviez", str4, function9, function10, this);
                                            if (hindMoviezLinks == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            semaphore6 = semaphore5;
                                            obj8 = hindMoviezLinks;
                                            obj3 = obj8;
                                            r2 = semaphore6;
                                            r2.release();
                                            return obj3;
                                        }
                                        semaphore4 = semaphore5;
                                    }
                                    obj3 = Unit.INSTANCE;
                                    r2 = semaphore4;
                                    r2.release();
                                    return obj3;
                                }
                                semaphore4 = semaphore3;
                                obj3 = Unit.INSTANCE;
                                r2 = semaphore4;
                            } catch (Exception e4) {
                                e = e4;
                                coroutine_suspended = semaphore3;
                                Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                                r2 = coroutine_suspended;
                                obj3 = null;
                            } catch (Throwable th4) {
                                th = th4;
                                coroutine_suspended = semaphore3;
                                coroutine_suspended.release();
                                throw th;
                            }
                            r2.release();
                            return obj3;
                        case 3:
                            i2 = 0;
                            i = 0;
                            i5 = 0;
                            str3 = (String) this.L$5;
                            document2 = (Document) this.L$4;
                            element4 = (Element) this.L$3;
                            continuation3 = (Continuation) this.L$2;
                            obj7 = this.L$1;
                            semaphore5 = (Semaphore) this.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                obj6 = obj;
                                semaphore5 = semaphore5;
                                str4 = (String) obj6;
                                if (str4 == null) {
                                    semaphore4 = semaphore5;
                                    obj3 = Unit.INSTANCE;
                                    r2 = semaphore4;
                                    r2.release();
                                    return obj3;
                                }
                                Function1 function11 = this.$subtitleCallback$inlined;
                                Function1 function12 = this.$callback$inlined;
                                this.L$0 = semaphore5;
                                this.L$1 = obj7;
                                this.L$2 = SpillingKt.nullOutSpilledVariable(continuation3);
                                this.L$3 = SpillingKt.nullOutSpilledVariable(element4);
                                this.L$4 = SpillingKt.nullOutSpilledVariable(document2);
                                this.L$5 = SpillingKt.nullOutSpilledVariable(str4);
                                this.L$6 = SpillingKt.nullOutSpilledVariable(str3);
                                this.L$7 = null;
                                this.L$8 = null;
                                this.label = 4;
                                hindMoviezLinks = StreamPlayUtilsKt.getHindMoviezLinks("Hindmoviez", str4, function11, function12, this);
                                if (hindMoviezLinks == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                semaphore6 = semaphore5;
                                obj8 = hindMoviezLinks;
                                obj3 = obj8;
                                r2 = semaphore6;
                                r2.release();
                                return obj3;
                            } catch (Exception e5) {
                                e = e5;
                                obj2 = obj7;
                                coroutine_suspended = semaphore5;
                                Log.INSTANCE.e("safeMap", "Request failed for " + obj2 + ' ' + e);
                                r2 = coroutine_suspended;
                                obj3 = null;
                            } catch (Throwable th5) {
                                th = th5;
                                coroutine_suspended = semaphore5;
                                coroutine_suspended.release();
                                throw th;
                            }
                            break;
                        case 4:
                            i2 = 0;
                            i = 0;
                            Object obj10 = this.L$1;
                            Semaphore semaphore10 = (Semaphore) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            obj8 = obj;
                            semaphore6 = semaphore10;
                            obj3 = obj8;
                            r2 = semaphore6;
                            r2.release();
                            return obj3;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Exception e6) {
                e = e6;
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
                    destination$iv$iv2.add(BuildersKt.async$default($this$coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new AnonymousClass1(semaphore, item$iv$iv, null, this.$season$inlined, this.$episode$inlined, this.$subtitleCallback$inlined, this.$callback$inlined), 2, (Object) null));
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
