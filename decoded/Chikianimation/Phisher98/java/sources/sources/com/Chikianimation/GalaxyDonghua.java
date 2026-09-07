package com.Chikianimation;

import android.util.Base64;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Extractor.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Chikianimation/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\r\u0018\u0000 72\u00020\u0001:\u000278B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00120\u00162\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00120\u0016H\u0096@¢\u0006\u0002\u0010\u001aJ\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u0005H\u0002J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0005H\u0002J\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050!2\u0006\u0010\u001f\u001a\u00020\u0005H\u0002J\u0017\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010\u001f\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010$J\u0018\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020#H\u0002J\u001a\u0010(\u001a\u0004\u0018\u00010\u00052\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0005H\u0002J*\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010*\u001a\u00020,2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020#2\u0006\u0010/\u001a\u00020#H\u0002J\u001a\u00100\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u0005H\u0002J\"\u00102\u001a\u0004\u0018\u00010\u00052\u0006\u00103\u001a\u00020,2\u0006\u00104\u001a\u00020,2\u0006\u00105\u001a\u00020,H\u0002J\u0010\u00106\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u00069"}, d2 = {"Lcom/Chikianimation/GalaxyDonghua;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "decodeGdTokens", "Lcom/Chikianimation/GalaxyDonghua$GdTokens;", "page", "stripConstants", "s", "splitTopLevelTerms", "", "evalArithmetic", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "packrBase36", "c", "a", "dcx", "input", "password", "pbkdf2Sha256", "", "salt", "iterations", "dkLen", "fixStreamUrl", "base", "aesDecrypt", "blob", "key", "iv", "embedHost", "Companion", "GdTokens", "Chikianimation"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractor.kt\ncom/Chikianimation/GalaxyDonghua\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,409:1\n1#2:410\n777#3:411\n873#3,2:412\n437#4:414\n513#4,5:415\n*S KotlinDebug\n*F\n+ 1 Extractor.kt\ncom/Chikianimation/GalaxyDonghua\n*L\n280#1:411\n280#1:412,2\n284#1:414\n284#1:415,5\n*E\n"})
public final class GalaxyDonghua extends ExtractorApi {

    /* JADX INFO: renamed from: GX */
    @NotNull
    public static final String f0GX = "https://galaxydonghua.xyz";

    /* JADX INFO: renamed from: UA */
    @NotNull
    public static final String f1UA = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36";

    @NotNull
    private String name = "GalaxyDonghua";

    @NotNull
    private String mainUrl = f0GX;
    private final boolean requiresReferer = true;

    /* JADX INFO: renamed from: com.Chikianimation.GalaxyDonghua$getUrl$1 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Chikianimation.GalaxyDonghua", f = "Extractor.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6}, l = {66, 78, 104, 129, 132, 142, 157}, m = "getUrl", n = {"url", "referer", "subtitleCallback", "callback", "embedHost", "gxBase", "headers", "url", "referer", "subtitleCallback", "callback", "embedHost", "gxBase", "headers", "page", "tokens", "apiConfigBase", "url", "referer", "subtitleCallback", "callback", "embedHost", "gxBase", "headers", "page", "tokens", "apiConfigBase", "configRes", "configPlain", "pConf", "apiURL", "fixedApi", "apiHeaders", "url", "referer", "subtitleCallback", "callback", "embedHost", "gxBase", "headers", "page", "tokens", "apiConfigBase", "configRes", "configPlain", "pConf", "apiURL", "fixedApi", "apiHeaders", "apiBody", "apiPlain", "resJson", "sources", "baseURL", "src", "file", "label", "type", "i", "isM3u8", "quality", "url", "referer", "subtitleCallback", "callback", "embedHost", "gxBase", "headers", "page", "tokens", "apiConfigBase", "configRes", "configPlain", "pConf", "apiURL", "fixedApi", "apiHeaders", "apiBody", "apiPlain", "resJson", "sources", "baseURL", "src", "file", "label", "type", "links", "i", "isM3u8", "quality", "url", "referer", "subtitleCallback", "callback", "embedHost", "gxBase", "headers", "page", "tokens", "apiConfigBase", "configRes", "configPlain", "pConf", "apiURL", "fixedApi", "apiHeaders", "apiBody", "apiPlain", "resJson", "sources", "baseURL", "src", "file", "label", "type", "i", "isM3u8", "quality", "url", "referer", "subtitleCallback", "callback", "embedHost", "gxBase", "headers", "page", "tokens", "apiConfigBase", "configRes", "configPlain", "pConf", "apiURL", "fixedApi", "apiHeaders", "apiBody", "apiPlain", "resJson", "sources", "baseURL", "tracks", "tr", "file", "i"}, nl = {70, 85, 108, 130, 131, 141, 158}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "I$0", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "I$0", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "I$0", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "I$0"}, v = 2)
    static final class C00101 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
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
        Object L$23;
        Object L$24;
        Object L$25;
        Object L$26;
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
            return GalaxyDonghua.this.getUrl(null, null, null, null, (Continuation) this);
        }
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    public void setName(@NotNull String str) {
        this.name = str;
    }

    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    public void setMainUrl(@NotNull String str) {
        this.mainUrl = str;
    }

    public boolean getRequiresReferer() {
        return this.requiresReferer;
    }

    /* JADX WARN: Code duplicated, block: B:282:0x1076  */
    /* JADX WARN: Code duplicated, block: B:284:0x107c  */
    /* JADX WARN: Code duplicated, block: B:285:0x107f  */
    /* JADX WARN: Code duplicated, block: B:287:0x108c  */
    /* JADX WARN: Code duplicated, block: B:288:0x1096  */
    /* JADX WARN: Code duplicated, block: B:291:0x10a6  */
    /* JADX WARN: Code duplicated, block: B:304:0x1178 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:305:0x1179  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 13, insn: 0x039f: MOVE (r27 I:??[OBJECT, ARRAY]) = (r13 I:??[OBJECT, ARRAY] A[D('baseURL' java.lang.String)]), block:B:29:0x0396 */
    /* JADX WARN: Not initialized variable reg: 31, insn: 0x0396: MOVE (r18 I:??[OBJECT, ARRAY]) = (r31 I:??[OBJECT, ARRAY] A[D('fixedApi' java.lang.String)]), block:B:29:0x0396 */
    /* JADX WARN: Type inference failed for: r10v31 */
    /* JADX WARN: Type inference failed for: r10v35 */
    /* JADX WARN: Type inference failed for: r10v36 */
    /* JADX WARN: Type inference failed for: r10v37 */
    /* JADX WARN: Type inference failed for: r10v38 */
    /* JADX WARN: Type inference failed for: r10v41 */
    /* JADX WARN: Type inference failed for: r10v86 */
    /* JADX WARN: Type inference failed for: r10v87 */
    /* JADX WARN: Type inference failed for: r10v88 */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v116 */
    /* JADX WARN: Type inference failed for: r14v32 */
    /* JADX WARN: Type inference failed for: r14v35 */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r14v96 */
    /* JADX WARN: Type inference failed for: r17v10 */
    /* JADX WARN: Type inference failed for: r17v19 */
    /* JADX WARN: Type inference failed for: r17v2 */
    /* JADX WARN: Type inference failed for: r17v20 */
    /* JADX WARN: Type inference failed for: r17v21 */
    /* JADX WARN: Type inference failed for: r17v22 */
    /* JADX WARN: Type inference failed for: r17v23 */
    /* JADX WARN: Type inference failed for: r17v24 */
    /* JADX WARN: Type inference failed for: r17v25 */
    /* JADX WARN: Type inference failed for: r17v26 */
    /* JADX WARN: Type inference failed for: r17v7 */
    /* JADX WARN: Type inference failed for: r17v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r17v9 */
    /* JADX WARN: Type inference failed for: r1v21, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r20v0 */
    /* JADX WARN: Type inference failed for: r20v1 */
    /* JADX WARN: Type inference failed for: r20v14 */
    /* JADX WARN: Type inference failed for: r20v16 */
    /* JADX WARN: Type inference failed for: r20v2 */
    /* JADX WARN: Type inference failed for: r20v28 */
    /* JADX WARN: Type inference failed for: r20v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r20v35 */
    /* JADX WARN: Type inference failed for: r20v36 */
    /* JADX WARN: Type inference failed for: r20v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r20v41 */
    /* JADX WARN: Type inference failed for: r20v42 */
    /* JADX WARN: Type inference failed for: r20v43 */
    /* JADX WARN: Type inference failed for: r20v44 */
    /* JADX WARN: Type inference failed for: r20v45 */
    /* JADX WARN: Type inference failed for: r20v46 */
    /* JADX WARN: Type inference failed for: r20v47 */
    /* JADX WARN: Type inference failed for: r20v48 */
    /* JADX WARN: Type inference failed for: r20v49 */
    /* JADX WARN: Type inference failed for: r20v5 */
    /* JADX WARN: Type inference failed for: r20v50 */
    /* JADX WARN: Type inference failed for: r20v51 */
    /* JADX WARN: Type inference failed for: r20v52 */
    /* JADX WARN: Type inference failed for: r20v53 */
    /* JADX WARN: Type inference failed for: r20v54 */
    /* JADX WARN: Type inference failed for: r20v55 */
    /* JADX WARN: Type inference failed for: r20v56 */
    /* JADX WARN: Type inference failed for: r20v57 */
    /* JADX WARN: Type inference failed for: r20v58 */
    /* JADX WARN: Type inference failed for: r20v59 */
    /* JADX WARN: Type inference failed for: r20v6 */
    /* JADX WARN: Type inference failed for: r20v60 */
    /* JADX WARN: Type inference failed for: r20v61 */
    /* JADX WARN: Type inference failed for: r20v62 */
    /* JADX WARN: Type inference failed for: r20v63 */
    /* JADX WARN: Type inference failed for: r20v64 */
    /* JADX WARN: Type inference failed for: r20v65 */
    /* JADX WARN: Type inference failed for: r20v66 */
    /* JADX WARN: Type inference failed for: r20v8 */
    /* JADX WARN: Type inference failed for: r20v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v42 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v27 */
    /* JADX WARN: Type inference failed for: r7v29 */
    /* JADX WARN: Type inference failed for: r7v31 */
    /* JADX WARN: Type inference failed for: r7v33 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v76 */
    /* JADX WARN: Type inference failed for: r7v77 */
    /* JADX WARN: Type inference failed for: r7v78 */
    /* JADX WARN: Type inference failed for: r7v79 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 19 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:205:0x0c12 -> B:277:0x102d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:218:0x0cc6 -> B:277:0x102d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:252:0x0eba -> B:400:0x0ed5). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:276:0x1020 -> B:277:0x102d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:305:0x1179 -> B:372:0x1192). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:319:0x121b -> B:320:0x122f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getUrl(@org.jetbrains.annotations.NotNull java.lang.String r68, @org.jetbrains.annotations.Nullable java.lang.String r69, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r70, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r71, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r72) {
        /*
            Method dump skipped, instruction units count: 5118
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.Chikianimation.GalaxyDonghua.getUrl(java.lang.String, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.Chikianimation.GalaxyDonghua$getUrl$2 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Chikianimation.GalaxyDonghua$getUrl$2", f = "Extractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00112 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $quality;
        final /* synthetic */ String $url;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00112(String str, int i, Continuation<? super C00112> continuation) {
            super(2, continuation);
            this.$url = str;
            this.$quality = i;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00112 = new C00112(this.$url, this.$quality, continuation);
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
                    $this$newExtractorLink.setReferer(this.$url);
                    $this$newExtractorLink.setQuality(this.$quality);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.Chikianimation.GalaxyDonghua$getUrl$3 */
    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Chikianimation.GalaxyDonghua$getUrl$3", f = "Extractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00123 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $quality;
        final /* synthetic */ String $url;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00123(String str, int i, Continuation<? super C00123> continuation) {
            super(2, continuation);
            this.$url = str;
            this.$quality = i;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00123 = new C00123(this.$url, this.$quality, continuation);
            c00123.L$0 = obj;
            return c00123;
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
                    $this$newExtractorLink.setReferer(this.$url);
                    $this$newExtractorLink.setQuality(this.$quality);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: compiled from: Extractor.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/Chikianimation/GalaxyDonghua$GdTokens;", "", "pd", "", "ps", "qsx", "kaken", "apx", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPd", "()Ljava/lang/String;", "getPs", "getQsx", "getKaken", "getApx", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "Chikianimation"}, k = 1, mv = {2, 4, 0}, xi = 48)
    private static final /* data */ class GdTokens {

        @NotNull
        private final String apx;

        @NotNull
        private final String kaken;

        @NotNull
        private final String pd;

        @NotNull
        private final String ps;

        @NotNull
        private final String qsx;

        public static /* synthetic */ GdTokens copy$default(GdTokens gdTokens, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
            if ((i & 1) != 0) {
                str = gdTokens.pd;
            }
            if ((i & 2) != 0) {
                str2 = gdTokens.ps;
            }
            if ((i & 4) != 0) {
                str3 = gdTokens.qsx;
            }
            if ((i & 8) != 0) {
                str4 = gdTokens.kaken;
            }
            if ((i & 16) != 0) {
                str5 = gdTokens.apx;
            }
            String str6 = str5;
            String str7 = str3;
            return gdTokens.copy(str, str2, str7, str4, str6);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getPd() {
            return this.pd;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getPs() {
            return this.ps;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getQsx() {
            return this.qsx;
        }

        @NotNull
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getKaken() {
            return this.kaken;
        }

        @NotNull
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getApx() {
            return this.apx;
        }

        @NotNull
        public final GdTokens copy(@NotNull String pd, @NotNull String ps, @NotNull String qsx, @NotNull String kaken, @NotNull String apx) {
            return new GdTokens(pd, ps, qsx, kaken, apx);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GdTokens)) {
                return false;
            }
            GdTokens gdTokens = (GdTokens) other;
            return Intrinsics.areEqual(this.pd, gdTokens.pd) && Intrinsics.areEqual(this.ps, gdTokens.ps) && Intrinsics.areEqual(this.qsx, gdTokens.qsx) && Intrinsics.areEqual(this.kaken, gdTokens.kaken) && Intrinsics.areEqual(this.apx, gdTokens.apx);
        }

        public int hashCode() {
            return (((((((this.pd.hashCode() * 31) + this.ps.hashCode()) * 31) + this.qsx.hashCode()) * 31) + this.kaken.hashCode()) * 31) + this.apx.hashCode();
        }

        @NotNull
        public String toString() {
            return "GdTokens(pd=" + this.pd + ", ps=" + this.ps + ", qsx=" + this.qsx + ", kaken=" + this.kaken + ", apx=" + this.apx + ')';
        }

        public GdTokens(@NotNull String pd, @NotNull String ps, @NotNull String qsx, @NotNull String kaken, @NotNull String apx) {
            this.pd = pd;
            this.ps = ps;
            this.qsx = qsx;
            this.kaken = kaken;
            this.apx = apx;
        }

        @NotNull
        public final String getPd() {
            return this.pd;
        }

        @NotNull
        public final String getPs() {
            return this.ps;
        }

        @NotNull
        public final String getQsx() {
            return this.qsx;
        }

        @NotNull
        public final String getKaken() {
            return this.kaken;
        }

        @NotNull
        public final String getApx() {
            return this.apx;
        }
    }

    private final GdTokens decodeGdTokens(String page) throws IOException {
        int v;
        int packedStart;
        int packedEnd;
        String ps;
        String qsx;
        String kaken;
        String apx;
        Integer numEvalArithmetic;
        int v2;
        int jStart = StringsKt.indexOf$default(page, "ﾟωﾟﾉ=", 0, false, 6, (Object) null);
        if (jStart < 0 || (v = StringsKt.indexOf$default(page, ") (ﾟΘﾟ)) ('_')", jStart, false, 4, (Object) null)) < 0) {
            return null;
        }
        String jsfuck = page.substring(jStart, v + 14);
        Intrinsics.checkNotNullExpressionValue(jsfuck, "substring(...)");
        int bStart = StringsKt.indexOf$default(jsfuck, "(ﾟεﾟ+/*´∇｀*/", 0, false, 6, (Object) null);
        if (bStart < 0) {
            return null;
        }
        int bodyStart = bStart + 12;
        String body = jsfuck.substring(bodyStart, v);
        Intrinsics.checkNotNullExpressionValue(body, "substring(...)");
        int oMarker = StringsKt.lastIndexOf$default(body, "(ﾟДﾟ)[ﾟoﾟ]", 0, false, 6, (Object) null);
        if (oMarker >= 0) {
            String strSubstring = body.substring(0, oMarker);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            body = strSubstring;
        }
        List segs = StringsKt.split$default(body, new String[]{"(ﾟДﾟ)[ﾟεﾟ]"}, false, 0, 6, (Object) null);
        StringBuilder sb = new StringBuilder();
        int i = 1;
        int size = segs.size();
        while (i < size) {
            String st = StringsKt.trimEnd(StringsKt.trimStart(StringsKt.trim(stripConstants((String) segs.get(i))).toString(), new char[]{'+'}), new char[]{'+'});
            StringBuilder digits = new StringBuilder();
            for (String term : splitTopLevelTerms(st)) {
                String t = StringsKt.trim(term).toString();
                String st2 = st;
                int jEnd = v;
                String jsfuck2 = jsfuck;
                int bStart2 = bStart;
                if (StringsKt.startsWith$default(t, "-", false, 2, (Object) null)) {
                    String strSubstring2 = t.substring(1);
                    Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                    Integer numEvalArithmetic2 = evalArithmetic(strSubstring2);
                    if (numEvalArithmetic2 == null) {
                        return null;
                    }
                    numEvalArithmetic = Integer.valueOf(-numEvalArithmetic2.intValue());
                } else {
                    numEvalArithmetic = evalArithmetic(StringsKt.trimStart(t, new char[]{'+'}));
                }
                if (numEvalArithmetic == null || (v2 = numEvalArithmetic.intValue()) < 0 || v2 > 7) {
                    return null;
                }
                digits.append(v2);
                st = st2;
                v = jEnd;
                jsfuck = jsfuck2;
                bStart = bStart2;
            }
            int jEnd2 = v;
            String jsfuck3 = jsfuck;
            int bStart3 = bStart;
            if (digits.length() > 0) {
                sb.append((char) Integer.parseInt(digits.toString(), CharsKt.checkRadix(8)));
            }
            i++;
            v = jEnd2;
            jsfuck = jsfuck3;
            bStart = bStart3;
        }
        String packrCall = sb.toString();
        int pStart = StringsKt.indexOf$default(packrCall, "}('", 0, false, 6, (Object) null);
        if (pStart < 0 || (packedEnd = StringsKt.indexOf$default(packrCall, "',", (packedStart = pStart + 3), false, 4, (Object) null)) < 0) {
            return null;
        }
        String packed = packrCall.substring(packedStart, packedEnd);
        Intrinsics.checkNotNullExpressionValue(packed, "substring(...)");
        int num1Start = packedEnd + 2;
        int num1End = StringsKt.indexOf$default(packrCall, ",", num1Start, false, 4, (Object) null);
        if (num1End < 0) {
            return null;
        }
        String strSubstring3 = packrCall.substring(num1Start, num1End);
        Intrinsics.checkNotNullExpressionValue(strSubstring3, "substring(...)");
        Integer intOrNull = StringsKt.toIntOrNull(strSubstring3);
        if (intOrNull == null) {
            return null;
        }
        int a = intOrNull.intValue();
        int dictStartRaw = StringsKt.indexOf$default(packrCall, ",'", num1End, false, 4, (Object) null);
        if (dictStartRaw < 0) {
            return null;
        }
        int dictStart = dictStartRaw + 2;
        int dictEnd = StringsKt.indexOf$default(packrCall, "'.split", dictStart, false, 4, (Object) null);
        int dictStart2 = dictStart;
        if (dictEnd < 0) {
            return null;
        }
        String strSubstring4 = packrCall.substring(dictStart2, dictEnd);
        Intrinsics.checkNotNullExpressionValue(strSubstring4, "substring(...)");
        List dict = StringsKt.split$default(strSubstring4, new String[]{"|"}, false, 0, 6, (Object) null);
        Ref.ObjectRef code = new Ref.ObjectRef();
        code.element = packed;
        int c = a - 1;
        while (true) {
            int dictEnd2 = dictEnd;
            if (-1 >= c) {
                break;
            }
            String k = (String) CollectionsKt.getOrNull(dict, c);
            if (k != null) {
                if (!(k.length() == 0)) {
                    code.element = new Regex("\\b" + packrBase36(c, a) + "\\b").replace((CharSequence) code.element, k);
                }
            }
            c--;
            dictEnd = dictEnd2;
            dictStart2 = dictStart2;
            dict = dict;
            bodyStart = bodyStart;
            body = body;
            oMarker = oMarker;
        }
        String pd = decodeGdTokens$grab(code, new Regex("pd=\"([^\"]+)\""));
        if (pd == null || (ps = decodeGdTokens$grab(code, new Regex("ps=\"([^\"]+)\""))) == null || (qsx = decodeGdTokens$grab(code, new Regex("window\\.qsx=\"([^\"]+)\""))) == null || (kaken = decodeGdTokens$grab(code, new Regex("window\\.kaken=\"([^\"]+)\""))) == null || (apx = decodeGdTokens$grab(code, new Regex("window\\.apx=\"([^\"]+)\""))) == null || StringsKt.isBlank(pd) || StringsKt.isBlank(ps) || StringsKt.isBlank(qsx) || StringsKt.isBlank(kaken) || StringsKt.isBlank(apx)) {
            return null;
        }
        return new GdTokens(pd, ps, qsx, kaken, apx);
    }

    private static final String decodeGdTokens$grab(Ref.ObjectRef<String> objectRef, Regex regex) {
        List groupValues;
        String str;
        MatchResult matchResultFind$default = Regex.find$default(regex, (CharSequence) objectRef.element, 0, 2, (Object) null);
        if (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null || (str = (String) groupValues.get(1)) == null) {
            return null;
        }
        return StringsKt.trim(str).toString();
    }

    private final String stripConstants(String s) {
        List<Pair> repl = CollectionsKt.listOf(new Pair[]{TuplesKt.to("(c^_^o)", "0"), TuplesKt.to("(o^_^o)", "3"), TuplesKt.to("(ﾟΘﾟ)", "1"), TuplesKt.to("(ﾟｰﾟ)", "4"), TuplesKt.to("c^_^o", "0"), TuplesKt.to("o^_^o", "3"), TuplesKt.to("ﾟΘﾟ", "1"), TuplesKt.to("ﾟｰﾟ", "4")});
        String t = s;
        for (Pair pair : repl) {
            String k = (String) pair.component1();
            String v = (String) pair.component2();
            t = StringsKt.replace$default(t, k, v, false, 4, (Object) null);
        }
        return t;
    }

    private final List<String> splitTopLevelTerms(String s) {
        List terms = new ArrayList();
        int depth = 0;
        StringBuilder cur = new StringBuilder();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '(':
                    depth++;
                    cur.append(ch);
                    break;
                case ')':
                    depth--;
                    cur.append(ch);
                    break;
                case '*':
                case ',':
                default:
                    cur.append(ch);
                    break;
                case '+':
                case '-':
                    if (depth == 0) {
                        if (!StringsKt.isBlank(cur)) {
                            terms.add(cur.toString());
                        }
                        cur = new StringBuilder().append(ch);
                        Unit unit = Unit.INSTANCE;
                    } else {
                        cur.append(ch);
                    }
                    break;
            }
        }
        if (!StringsKt.isBlank(cur)) {
            terms.add(cur.toString());
        }
        List $this$filter$iv = terms;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            String it = (String) element$iv$iv;
            if ((Intrinsics.areEqual(it, "+") || Intrinsics.areEqual(it, "-")) ? false : true) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return (List) destination$iv$iv;
    }

    private final Integer evalArithmetic(String s) throws IOException {
        String $this$filterTo$iv$iv = s;
        Appendable destination$iv$iv = new StringBuilder();
        int index$iv$iv = 0;
        int length = $this$filterTo$iv$iv.length();
        while (true) {
            if (index$iv$iv >= length) {
                break;
            }
            char element$iv$iv = $this$filterTo$iv$iv.charAt(index$iv$iv);
            if (element$iv$iv != ' ') {
                destination$iv$iv.append(element$iv$iv);
            }
            index$iv$iv++;
        }
        String $this$filter$iv = ((StringBuilder) destination$iv$iv).toString();
        List values = new ArrayList();
        List ops = new ArrayList();
        int i = 0;
        while (i < $this$filter$iv.length()) {
            char c = $this$filter$iv.charAt(i);
            if (Character.isDigit(c)) {
                int v = 0;
                while (i < $this$filter$iv.length() && Character.isDigit($this$filter$iv.charAt(i))) {
                    v = (v * 10) + ($this$filter$iv.charAt(i) - '0');
                    i++;
                }
                values.add(Integer.valueOf(v));
            } else if (c == '(') {
                ops.add(Character.valueOf(c));
                i++;
            } else if (c == ')') {
                while (!ops.isEmpty() && ((Character) CollectionsKt.last(ops)).charValue() != '(') {
                    if (values.size() < 2) {
                        return null;
                    }
                    int b = ((Number) values.remove(values.size() - 1)).intValue();
                    int a = ((Number) values.remove(values.size() - 1)).intValue();
                    values.add(Integer.valueOf(((Character) ops.remove(ops.size() - 1)).charValue() == '+' ? a + b : a - b));
                }
                if (ops.isEmpty()) {
                    return null;
                }
                ops.remove(ops.size() - 1);
                i++;
            } else {
                if (c != '+' && c != '-') {
                    return null;
                }
                while (!ops.isEmpty() && ((Character) CollectionsKt.last(ops)).charValue() != '(') {
                    if (values.size() < 2) {
                        return null;
                    }
                    int b2 = ((Number) values.remove(values.size() - 1)).intValue();
                    int a2 = ((Number) values.remove(values.size() - 1)).intValue();
                    values.add(Integer.valueOf(((Character) ops.remove(ops.size() - 1)).charValue() == '+' ? a2 + b2 : a2 - b2));
                }
                ops.add(Character.valueOf(c));
                i++;
            }
        }
        while (!ops.isEmpty()) {
            if (((Character) CollectionsKt.last(ops)).charValue() == '(' || values.size() < 2) {
                return null;
            }
            int b3 = ((Number) values.remove(values.size() - 1)).intValue();
            int a3 = ((Number) values.remove(values.size() - 1)).intValue();
            values.add(Integer.valueOf(((Character) ops.remove(ops.size() - 1)).charValue() == '+' ? a3 + b3 : a3 - b3));
        }
        if (values.size() == 1) {
            return (Integer) values.get(0);
        }
        return null;
    }

    private final String packrBase36(int c, int a) {
        String prefix = c < a ? "" : packrBase36(c / a, a);
        int rem = c % a;
        String suffix = String.valueOf(rem > 35 ? (char) (rem + 29) : Character.forDigit(rem, 36));
        return prefix + suffix;
    }

    private final String dcx(String input, String password) {
        try {
            byte[] data = Base64.decode(StringsKt.trim(input).toString(), 0);
            if (data.length < 16) {
                return null;
            }
            byte[] salt = ArraysKt.copyOfRange(data, 0, 16);
            byte[] ct = ArraysKt.copyOfRange(data, 16, data.length);
            byte[] bytes = password.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            byte[] derived = pbkdf2Sha256(bytes, salt, 10000, 48);
            if (derived == null) {
                return null;
            }
            return aesDecrypt(ct, ArraysKt.copyOfRange(derived, 0, 32), ArraysKt.copyOfRange(derived, 32, 48));
        } catch (Exception e) {
            return null;
        }
    }

    private final byte[] pbkdf2Sha256(byte[] password, byte[] salt, int iterations, int dkLen) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            try {
                mac.init(new SecretKeySpec(password, "HmacSHA256"));
                byte[] out = new byte[dkLen];
                int blocks = ((dkLen + 32) - 1) / 32;
                if (1 > blocks) {
                    return out;
                }
                int offset = 0;
                int block = 1;
                while (true) {
                    int offset2 = salt.length;
                    byte[] u = new byte[offset2 + 4];
                    ArraysKt.copyInto$default(salt, u, 0, 0, 0, 14, (Object) null);
                    int bi = block;
                    u[salt.length] = (byte) ((bi >>> 24) & 255);
                    u[salt.length + 1] = (byte) ((bi >>> 16) & 255);
                    u[salt.length + 2] = (byte) ((bi >>> 8) & 255);
                    u[salt.length + 3] = (byte) (bi & 255);
                    byte[] t = mac.doFinal(u);
                    byte[] last = t;
                    for (int i = 1; i < iterations; i++) {
                        try {
                            last = mac.doFinal(last);
                            int j = 0;
                            for (int length = t.length; j < length; length = length) {
                                t[j] = (byte) (t[j] ^ last[j]);
                                j++;
                            }
                        } catch (Exception e) {
                        }
                    }
                    int n = Math.min(32, dkLen - offset);
                    ArraysKt.copyInto(t, out, offset, 0, n);
                    offset += n;
                    if (block == blocks) {
                        return out;
                    }
                    block++;
                }
            } catch (Exception e2) {
            }
        } catch (Exception e3) {
        }
        return null;
    }

    private final String fixStreamUrl(String url, String base) {
        Object obj;
        StringBuilder sb;
        StringBuilder sbAppend;
        StringBuilder sb2;
        StringBuilder sbAppend2;
        String u = StringsKt.trim(url).toString();
        if (StringsKt.isBlank(u)) {
            return null;
        }
        if (StringsKt.startsWith$default(u, "http://", false, 2, (Object) null) || StringsKt.startsWith$default(u, "https://", false, 2, (Object) null)) {
            return u;
        }
        if (StringsKt.startsWith$default(u, "//", false, 2, (Object) null)) {
            return "https:" + u;
        }
        try {
            Result.Companion companion = Result.Companion;
            GalaxyDonghua galaxyDonghua = this;
            URI uri = new URI(base);
            obj = Result.constructor-impl(uri.getScheme() + "://" + uri.getHost());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        String host = (String) obj;
        if (StringsKt.startsWith$default(u, "/", false, 2, (Object) null)) {
            if (host != null) {
                sb2 = new StringBuilder();
                sbAppend2 = sb2.append(host);
            } else {
                sb2 = new StringBuilder();
                sbAppend2 = sb2.append(StringsKt.trimEnd(base, new char[]{'/'}));
            }
            return sbAppend2.append(u).toString();
        }
        if (host != null) {
            sb = new StringBuilder();
            sbAppend = sb.append(host);
        } else {
            sb = new StringBuilder();
            sbAppend = sb.append(StringsKt.trimEnd(base, new char[]{'/'}));
        }
        return sbAppend.append('/').append(u).toString();
    }

    private final String aesDecrypt(byte[] blob, byte[] key, byte[] iv) {
        if (!ArraysKt.contains(new int[]{16, 24, 32}, key.length) || iv.length != 16) {
            return null;
        }
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, new SecretKeySpec(key, "AES"), new IvParameterSpec(iv));
            return new String(cipher.doFinal(blob), Charsets.UTF_8);
        } catch (Exception e) {
            return null;
        }
    }

    private final String embedHost(String url) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            GalaxyDonghua galaxyDonghua = this;
            URI uri = new URI(url);
            obj = Result.constructor-impl(uri.getScheme() + "://" + uri.getHost());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        String str = (String) obj;
        return str == null ? f0GX : str;
    }
}
