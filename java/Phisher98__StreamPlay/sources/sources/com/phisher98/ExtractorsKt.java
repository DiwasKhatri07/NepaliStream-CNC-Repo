package com.phisher98;

import com.google.gson.Gson;
import com.lagradost.cloudstream3.utils.Qualities;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Extractors.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u001a\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002\u001a\u001c\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0016\u001a\u00020\u0014H\u0002\u001a\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0018\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u0019\"\u001b\u0010\u0000\u001a\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"sharedGson", "Lcom/google/gson/Gson;", "getSharedGson", "()Lcom/google/gson/Gson;", "sharedGson$delegate", "Lkotlin/Lazy;", "extractorTitleExtensionRegex", "Lkotlin/text/Regex;", "extractorTitlePatterns", "", "extractorNormalizeWebDlRegex", "extractorNormalizeWebRipRegex", "extractorNormalizeH265Regex", "extractorNormalizeH264Regex", "extractorNormalizeDolbyVisionRegex", "extractorQualityRegex", "extractCleanTitle", "", "title", "extractIndexQuality", "", "str", "defaultQuality", "resolveFinalUrl", "startUrl", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "StreamPlay"}, k = 2, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractors.kt\ncom/phisher98/ExtractorsKt\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,4003:1\n1505#2,2:4004\n*S KotlinDebug\n*F\n+ 1 Extractors.kt\ncom/phisher98/ExtractorsKt\n*L\n95#1:4004,2\n*E\n"})
public final class ExtractorsKt {

    @NotNull
    private static final Lazy sharedGson$delegate = LazyKt.lazy(new Function0() { // from class: com.phisher98.ExtractorsKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            return ExtractorsKt.sharedGson_delegate$lambda$0();
        }
    });

    @NotNull
    private static final Regex extractorTitleExtensionRegex = new Regex("\\.[a-zA-Z0-9]{2,4}$");

    @NotNull
    private static final List<Regex> extractorTitlePatterns = CollectionsKt.listOf(new Regex[]{new Regex("(WEB[- ]?DL|WEB[- ]?RIP|WEBDL|WEBRIP|BLURAY|BDRIP|BRRIP|REMUX|HDRIP|DVDRIP|HDTV|UHD|CAM|TS|TC)", RegexOption.IGNORE_CASE), new Regex("(H[ .]?264|H[ .]?265|X264|X265|HEVC|AVC|AV1|VP9|XVID)", RegexOption.IGNORE_CASE), new Regex("(DDP?[ .]?[0-9]\\.[0-9]|DD[ .]?[0-9]\\.[0-9]|AAC[ .]?[0-9]\\.[0-9]|AC3|DTS[- ]?HD|DTS|EAC3|TRUEHD|ATMOS|FLAC|MP3|OPUS)", RegexOption.IGNORE_CASE), new Regex("(HDR10\\+?|HDR|DV|DOLBY[ .]?VISION)", RegexOption.IGNORE_CASE), new Regex("\\b(NF|AMZN|DSNP|HULU|CRAV|ATVP|HMAX|PCOK|STAN)\\b", RegexOption.IGNORE_CASE), new Regex("\\b(REPACK|PROPER|REAL|EXTENDED|UNCUT|REMASTERED|LIMITED|MULTI|DUAL)\\b", RegexOption.IGNORE_CASE)});

    @NotNull
    private static final Regex extractorNormalizeWebDlRegex = new Regex("WEB[-_. ]?DL");

    @NotNull
    private static final Regex extractorNormalizeWebRipRegex = new Regex("WEB[-_. ]?RIP");

    @NotNull
    private static final Regex extractorNormalizeH265Regex = new Regex("H[ .]?265");

    @NotNull
    private static final Regex extractorNormalizeH264Regex = new Regex("H[ .]?264");

    @NotNull
    private static final Regex extractorNormalizeDolbyVisionRegex = new Regex("DOLBY[ .]?VISION");

    @NotNull
    private static final Regex extractorQualityRegex = new Regex("(\\d{3,4})[pP]");

    /* JADX INFO: renamed from: com.phisher98.ExtractorsKt$resolveFinalUrl$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.ExtractorsKt", f = "Extractors.kt", i = {0, 0, 0, 0}, l = {3987}, m = "resolveFinalUrl", n = {"startUrl", "currentUrl", "loopCount", "maxRedirects"}, nl = {3988}, s = {"L$0", "L$1", "I$0", "I$1"}, v = 2)
    static final class C00191 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00191(Continuation<? super C00191> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ExtractorsKt.resolveFinalUrl(null, (Continuation) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Gson getSharedGson() {
        return (Gson) sharedGson$delegate.getValue();
    }

    static final Gson sharedGson_delegate$lambda$0() {
        return new Gson();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String extractCleanTitle(String title) {
        String name = extractorTitleExtensionRegex.replace(title, "");
        LinkedHashSet results = new LinkedHashSet();
        for (Regex pattern : extractorTitlePatterns) {
            Sequence $this$forEach$iv = Regex.findAll$default(pattern, name, 0, 2, (Object) null);
            for (Object element$iv : $this$forEach$iv) {
                MatchResult match = (MatchResult) element$iv;
                String upperCase = match.getValue().toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                String value = StringsKt.replace$default(extractorNormalizeDolbyVisionRegex.replace(extractorNormalizeH264Regex.replace(extractorNormalizeH265Regex.replace(extractorNormalizeWebRipRegex.replace(extractorNormalizeWebDlRegex.replace(upperCase, "WEB-DL"), "WEBRIP"), "H265"), "H264"), "DOLBYVISION"), "2160P", "4K", false, 4, (Object) null);
                results.add(value);
            }
        }
        return CollectionsKt.joinToString$default(results, " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    static /* synthetic */ int extractIndexQuality$default(String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = Qualities.Unknown.getValue();
        }
        return extractIndexQuality(str, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int extractIndexQuality(String str, int defaultQuality) {
        List groupValues;
        String str2;
        Integer intOrNull;
        MatchResult matchResultFind$default = Regex.find$default(extractorQualityRegex, str == null ? "" : str, 0, 2, (Object) null);
        return (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null || (str2 = (String) CollectionsKt.getOrNull(groupValues, 1)) == null || (intOrNull = StringsKt.toIntOrNull(str2)) == null) ? defaultQuality : intOrNull.intValue();
    }

    /* JADX WARN: Code duplicated, block: B:23:0x00ab A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:27:0x00bc A[Catch: Exception -> 0x00f4, TryCatch #2 {Exception -> 0x00f4, blocks: (B:25:0x00b1, B:27:0x00bc, B:36:0x00cf, B:38:0x00de), top: B:57:0x00b1 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:32:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:34:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:35:0x00ce A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:38:0x00de A[Catch: Exception -> 0x00f4, TRY_LEAVE, TryCatch #2 {Exception -> 0x00f4, blocks: (B:25:0x00b1, B:27:0x00bc, B:36:0x00cf, B:38:0x00de), top: B:57:0x00b1 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:42:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:59:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00ac -> B:57:0x00b1). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Object resolveFinalUrl(@org.jetbrains.annotations.NotNull java.lang.String r26, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.String> r27) {
        /*
            Method dump skipped, instruction units count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.ExtractorsKt.resolveFinalUrl(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
