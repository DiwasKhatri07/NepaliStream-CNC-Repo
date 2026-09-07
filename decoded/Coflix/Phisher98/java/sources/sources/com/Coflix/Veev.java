package com.Coflix;

import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.CharsKt;
import kotlin.text.MatchResult;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Coflix/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\u001c\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00140\u00142\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\u001e\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0014H\u0002JH\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001a0\u001e2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u001a0\u001eH\u0096@¢\u0006\u0002\u0010\"R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006#"}, d2 = {"Lcom/Coflix/Veev;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "jsInt", "", "x", "veevDecode", "encoded", "buildArray", "", "hexToString", "hex", "decodeUrl", "tArray", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Coflix"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractor.kt\ncom/Coflix/Veev\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,316:1\n1739#2:317\n1814#2,3:318\n546#2,6:321\n546#2,6:327\n*S KotlinDebug\n*F\n+ 1 Extractor.kt\ncom/Coflix/Veev\n*L\n143#1:317\n143#1:318,3\n178#1:321,6\n179#1:327,6\n*E\n"})
public class Veev extends ExtractorApi {
    private final boolean requiresReferer;

    @NotNull
    private final String name = "VeevTo";

    @NotNull
    private final String mainUrl = "https://veev.to";

    /* JADX INFO: renamed from: com.Coflix.Veev$getUrl$1 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Coflix.Veev", f = "Extractor.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {175, 212, 240}, m = "getUrl$suspendImpl", n = {"$this", "url", "referer", "subtitleCallback", "callback", "$this", "url", "referer", "subtitleCallback", "callback", "initialResponse", "pageHtml", "mediaId", "regex", "encodedStrings", "ch", "tArrays", "apiUrl", "$this", "url", "referer", "subtitleCallback", "callback", "initialResponse", "pageHtml", "mediaId", "regex", "encodedStrings", "ch", "tArrays", "apiUrl", "apiResponse", "jsonResponse", "fileObj", "dvArray", "tArray", "source", "encodedUrl", "firstDecode", "finalUrl", "i"}, nl = {176, 213, 239}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "I$0"}, v = 2)
    static final class C00101 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
        Object L$16;
        Object L$17;
        Object L$18;
        Object L$19;
        Object L$2;
        Object L$20;
        Object L$21;
        Object L$22;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C00101(Continuation<? super C00101> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Veev.getUrl$suspendImpl(Veev.this, null, null, null, null, (Continuation) this);
        }
    }

    @Nullable
    public Object getUrl(@NotNull String str, @Nullable String str2, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        return getUrl$suspendImpl(this, str, str2, function1, function2, continuation);
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    public boolean getRequiresReferer() {
        return this.requiresReferer;
    }

    private final int jsInt(String x) {
        Integer intOrNull = StringsKt.toIntOrNull(x);
        if (intOrNull != null) {
            return intOrNull.intValue();
        }
        return 0;
    }

    private final String veevDecode(String encoded) {
        String nc;
        try {
            List result = new ArrayList();
            Map lut = new LinkedHashMap();
            int n = 256;
            String c = String.valueOf(encoded.charAt(0));
            result.add(c);
            String strSubstring = encoded.substring(1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            int length = strSubstring.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = strSubstring.charAt(i);
                if (cCharAt < 256) {
                    nc = String.valueOf(cCharAt);
                } else {
                    nc = (String) lut.get(Integer.valueOf(cCharAt));
                    if (nc == null) {
                        nc = c + c.charAt(0);
                    }
                }
                result.add(nc);
                lut.put(Integer.valueOf(n), c + nc.charAt(0));
                n++;
                c = nc;
            }
            return CollectionsKt.joinToString$default(result, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        } catch (Exception e) {
            return encoded;
        }
    }

    private final List<List<Integer>> buildArray(String encoded) {
        try {
            List d = new ArrayList();
            char[] charArray = encoded.toCharArray();
            Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
            List chars = ArraysKt.toMutableList(charArray);
            if (chars.isEmpty()) {
                return d;
            }
            int count = jsInt(String.valueOf(((Character) chars.remove(0)).charValue()));
            while (count > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < count && !chars.isEmpty(); i++) {
                    String charValue = String.valueOf(((Character) chars.remove(0)).charValue());
                    int intValue = jsInt(charValue);
                    arrayList.add(0, Integer.valueOf(intValue));
                }
                d.add(arrayList);
                if (chars.isEmpty()) {
                    break;
                }
                count = jsInt(String.valueOf(((Character) chars.remove(0)).charValue()));
            }
            return d;
        } catch (Exception e) {
            return CollectionsKt.emptyList();
        }
    }

    private final String hexToString(String hex) throws Exception {
        try {
            String cleanHex = StringsKt.trim(hex).toString();
            String paddedHex = cleanHex.length() % 2 != 0 ? '0' + cleanHex : cleanHex;
            Iterable $this$map$iv = StringsKt.chunked(paddedHex, 2);
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                String it = (String) item$iv$iv;
                destination$iv$iv.add(Byte.valueOf((byte) Integer.parseInt(it, CharsKt.checkRadix(16))));
            }
            byte[] bytes = CollectionsKt.toByteArray((List) destination$iv$iv);
            return StringsKt.decodeToString(bytes);
        } catch (Exception e) {
            throw e;
        }
    }

    private final String decodeUrl(String encoded, List<Integer> tArray) {
        String ds = encoded;
        try {
            Iterator<Integer> it = tArray.iterator();
            while (it.hasNext()) {
                int t = it.next().intValue();
                if (t == 1) {
                    ds = StringsKt.reversed(ds).toString();
                }
                ds = StringsKt.replace$default(hexToString(ds), "dXRmOA==", "", false, 4, (Object) null);
            }
            return ds;
        } catch (Exception e) {
            return encoded;
        }
    }

    /* JADX WARN: Code duplicated, block: B:111:0x0459  */
    /* JADX WARN: Code duplicated, block: B:112:0x045b  */
    /* JADX WARN: Code duplicated, block: B:114:0x045f  */
    /* JADX WARN: Code duplicated, block: B:119:0x0486 A[Catch: Exception -> 0x0573, TRY_LEAVE, TryCatch #7 {Exception -> 0x0573, blocks: (B:117:0x047e, B:119:0x0486), top: B:171:0x047e }] */
    /* JADX WARN: Code duplicated, block: B:123:0x0528 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:124:0x0529  */
    /* JADX WARN: Code duplicated, block: B:136:0x05b1  */
    /* JADX WARN: Code duplicated, block: B:137:0x05bb  */
    /* JADX WARN: Code duplicated, block: B:165:0x043d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:124:0x0529 -> B:169:0x0541). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:135:0x05a4 -> B:138:0x05c3). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    static /* synthetic */ java.lang.Object getUrl$suspendImpl(com.Coflix.Veev r36, java.lang.String r37, java.lang.String r38, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r39, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r40, kotlin.coroutines.Continuation<? super kotlin.Unit> r41) {
        /*
            Method dump skipped, instruction units count: 1626
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.Coflix.Veev.getUrl$suspendImpl(com.Coflix.Veev, java.lang.String, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static final String getUrl$lambda$2(MatchResult it) {
        return (String) it.getGroupValues().get(1);
    }

    /* JADX INFO: renamed from: com.Coflix.Veev$getUrl$2 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Coflix.Veev$getUrl$2", f = "Extractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00112 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C00112(Continuation<? super C00112> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00112 = Veev.this.new C00112(continuation);
            c00112.L$0 = obj;
            return c00112;
        }

        public final Object invoke(ExtractorLink extractorLink, Continuation<? super Unit> continuation) {
            return create(extractorLink, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            ExtractorLink $this$newExtractorLink = (ExtractorLink) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$newExtractorLink.setReferer(Veev.this.getMainUrl() + '/');
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
