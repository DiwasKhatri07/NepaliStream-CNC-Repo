package com.phisher98;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Extractors.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/UHDmoviesProvider/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¨\u0006\u0004"}, d2 = {"removeLeadingIndex", "", "title", "cleanTitle", "UHDmoviesProvider"}, k = 2, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractors.kt\ncom/phisher98/ExtractorsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,274:1\n1960#2,3:275\n777#2:278\n873#2,2:279\n*S KotlinDebug\n*F\n+ 1 Extractors.kt\ncom/phisher98/ExtractorsKt\n*L\n254#1:275,3\n270#1:278\n270#1:279,2\n*E\n"})
public final class ExtractorsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String removeLeadingIndex(String title) {
        return new Regex("^[\\[(]?\\s*\\d+\\s*[])\\-_.]*\\s*").replace(title, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String cleanTitle(String title) {
        String normalized;
        List parts;
        Set sourceTags;
        boolean z;
        String name = new Regex("\\.[a-zA-Z0-9]{2,4}$").replace(title, "");
        String normalized2 = new Regex("DDP[ .]?([0-9]\\.[0-9])", RegexOption.IGNORE_CASE).replace(new Regex("H[ .]?264", RegexOption.IGNORE_CASE).replace(new Regex("H[ .]?265", RegexOption.IGNORE_CASE).replace(new Regex("WEB[-_. ]?RIP", RegexOption.IGNORE_CASE).replace(new Regex("WEB[-_. ]?DL", RegexOption.IGNORE_CASE).replace(name, "WEB-DL"), "WEBRIP"), "H265"), "H264"), "DDP$1");
        List<String> parts2 = StringsKt.split$default(normalized2, new String[]{" ", "_", "."}, false, 0, 6, (Object) null);
        Set sourceTags2 = SetsKt.setOf(new String[]{"WEB-DL", "WEBRIP", "BLURAY", "HDRIP", "DVDRIP", "HDTV", "CAM", "TS", "BRRIP", "BDRIP"});
        Set codecTags = SetsKt.setOf(new String[]{"H264", "H265", "X264", "X265", "HEVC", "AVC"});
        Iterable audioTags = SetsKt.setOf(new String[]{"AAC", "AC3", "DTS", "MP3", "FLAC", "DD", "DDP", "EAC3"});
        Set audioExtras = SetsKt.setOf("ATMOS");
        Set hdrTags = SetsKt.setOf(new String[]{"SDR", "HDR", "HDR10", "HDR10+", "DV", "DOLBYVISION"});
        List tags = new ArrayList();
        List titleParts = new ArrayList();
        for (String part : parts2) {
            String p = part.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(p, "toUpperCase(...)");
            if (sourceTags2.contains(p)) {
                tags.add(p);
            } else if (codecTags.contains(p)) {
                tags.add(p);
            } else {
                Iterable $this$any$iv = audioTags;
                String name2 = name;
                if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
                    normalized = normalized2;
                    parts = parts2;
                    sourceTags = sourceTags2;
                    z = false;
                } else {
                    Iterator it = $this$any$iv.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            normalized = normalized2;
                            parts = parts2;
                            sourceTags = sourceTags2;
                            z = false;
                            break;
                        }
                        Object element$iv = it.next();
                        String it2 = (String) element$iv;
                        normalized = normalized2;
                        parts = parts2;
                        sourceTags = sourceTags2;
                        if (StringsKt.startsWith$default(p, it2, false, 2, (Object) null)) {
                            z = true;
                            break;
                        }
                        normalized2 = normalized;
                        parts2 = parts;
                        sourceTags2 = sourceTags;
                    }
                }
                if (z) {
                    tags.add(p);
                    name = name2;
                    normalized2 = normalized;
                    parts2 = parts;
                    sourceTags2 = sourceTags;
                } else if (audioExtras.contains(p)) {
                    tags.add(p);
                    name = name2;
                    normalized2 = normalized;
                    parts2 = parts;
                    sourceTags2 = sourceTags;
                } else if (hdrTags.contains(p)) {
                    List list = tags;
                    String str = "DOLBYVISION";
                    if (!Intrinsics.areEqual(p, "DV") && !Intrinsics.areEqual(p, "DOLBYVISION")) {
                        str = p;
                    }
                    list.add(str);
                    name = name2;
                    normalized2 = normalized;
                    parts2 = parts;
                    sourceTags2 = sourceTags;
                } else if (Intrinsics.areEqual(p, "NF") || Intrinsics.areEqual(p, "CR")) {
                    tags.add(p);
                    name = name2;
                    normalized2 = normalized;
                    parts2 = parts;
                    sourceTags2 = sourceTags;
                } else {
                    titleParts.add(part);
                    name = name2;
                    normalized2 = normalized;
                    parts2 = parts;
                    sourceTags2 = sourceTags;
                }
            }
        }
        String cleanTitle = StringsKt.trim(new Regex("\\s+").replace(CollectionsKt.joinToString$default(titleParts, " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null), " ")).toString();
        String cleanTags = CollectionsKt.joinToString$default(CollectionsKt.distinct(tags), " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        Iterable $this$filter$iv = CollectionsKt.listOf(new String[]{cleanTitle, cleanTags});
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            String it3 = (String) element$iv$iv;
            if (!StringsKt.isBlank(it3)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return CollectionsKt.joinToString$default((List) destination$iv$iv, " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }
}
