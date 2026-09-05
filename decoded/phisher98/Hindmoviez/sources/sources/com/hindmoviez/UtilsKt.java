package com.hindmoviez;

import com.lagradost.cloudstream3.Actor;
import com.lagradost.cloudstream3.ActorData;
import com.lagradost.cloudstream3.ActorRole;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.SearchQuality;
import com.lagradost.cloudstream3.utils.Qualities;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Hindmoviez/classes.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u001a\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001\u001a\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001\u001a \u0010\n\u001a\u00020\u00012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00040\f\u001a \u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00040\f2\u0006\u0010\u0011\u001a\u00020\u0001\u001a\u0010\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001\u001a\u000e\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0001\"/\u0010\r\u001a \u0012\u0004\u0012\u00020\u0001\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\f0\u00040\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, d2 = {"cleanTitle", "", "raw", "parseCredits", "", "Lcom/lagradost/cloudstream3/ActorData;", "jsonText", "getSearchQuality", "Lcom/lagradost/cloudstream3/SearchQuality;", "check", "buildExtractedTitle", "extracted", "", "SPEC_OPTIONS", "getSPEC_OPTIONS", "()Ljava/util/Map;", "extractSpecs", "inputString", "getIndexQuality", "", "str", "hindmoviezBase64Url", "input", "Hindmoviez"}, k = 2, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Utils.kt\ncom/hindmoviez/UtilsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,261:1\n1#2:262\n1544#3:263\n1633#3,5:264\n777#3:270\n873#3,2:271\n1739#3:273\n1814#3,3:274\n221#4:269\n222#4:277\n*S KotlinDebug\n*F\n+ 1 Utils.kt\ncom/hindmoviez/UtilsKt\n*L\n142#1:263\n142#1:264,5\n217#1:270\n217#1:271,2\n221#1:273\n221#1:274,3\n216#1:269\n216#1:277\n*E\n"})
public final class UtilsKt {

    @NotNull
    private static final Map<String, List<Map<String, String>>> SPEC_OPTIONS = MapsKt.mapOf(new Pair[]{TuplesKt.to("quality", CollectionsKt.listOf(new Map[]{MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "BluRay"), TuplesKt.to("label", "BluRay")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "BluRay REMUX"), TuplesKt.to("label", "BluRay REMUX")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "BRRip"), TuplesKt.to("label", "BRRip")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "BDRip"), TuplesKt.to("label", "BDRip")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "WEB-DL"), TuplesKt.to("label", "WEB-DL")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "HDRip"), TuplesKt.to("label", "HDRip")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "DVDRip"), TuplesKt.to("label", "DVDRip")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "HDTV"), TuplesKt.to("label", "HDTV")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "CAM"), TuplesKt.to("label", "CAM")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "TeleSync"), TuplesKt.to("label", "TeleSync")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "SCR"), TuplesKt.to("label", "SCR")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "10bit"), TuplesKt.to("label", "10bit")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "8bit"), TuplesKt.to("label", "8bit")})})), TuplesKt.to("codec", CollectionsKt.listOf(new Map[]{MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "x264"), TuplesKt.to("label", "x264")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "x265"), TuplesKt.to("label", "x265 (HEVC)")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "h.264"), TuplesKt.to("label", "H.264 (AVC)")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "h.265"), TuplesKt.to("label", "H.265 (HEVC)")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "hevc"), TuplesKt.to("label", "HEVC")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "avc"), TuplesKt.to("label", "AVC")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "mpeg-2"), TuplesKt.to("label", "MPEG-2")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "mpeg-4"), TuplesKt.to("label", "MPEG-4")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "vp9"), TuplesKt.to("label", "VP9")})})), TuplesKt.to("audio", CollectionsKt.listOf(new Map[]{MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "AAC"), TuplesKt.to("label", "AAC")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "AC3"), TuplesKt.to("label", "AC3 (Dolby Digital)")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "DTS"), TuplesKt.to("label", "DTS")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "DTS-HD MA"), TuplesKt.to("label", "DTS-HD MA")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "TrueHD"), TuplesKt.to("label", "Dolby TrueHD")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "Atmos"), TuplesKt.to("label", "Dolby Atmos")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "DD+"), TuplesKt.to("label", "DD+")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "Dolby Digital Plus"), TuplesKt.to("label", "Dolby Digital Plus")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "DTS Lossless"), TuplesKt.to("label", "DTS Lossless")})})), TuplesKt.to("hdr", CollectionsKt.listOf(new Map[]{MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "DV"), TuplesKt.to("label", "Dolby Vision")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "HDR10+"), TuplesKt.to("label", "HDR10+")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "HDR"), TuplesKt.to("label", "HDR")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "SDR"), TuplesKt.to("label", "SDR")})})), TuplesKt.to("language", CollectionsKt.listOf(new Map[]{MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "HIN"), TuplesKt.to("label", "Hindi🇮🇳")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "Hindi"), TuplesKt.to("label", "Hindi🇮🇳")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "Tamil"), TuplesKt.to("label", "Tamil🇮🇳")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "ENG"), TuplesKt.to("label", "English🇺🇸")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "English"), TuplesKt.to("label", "English🇺🇸")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "Korean"), TuplesKt.to("label", "Korean🇰🇷")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "KOR"), TuplesKt.to("label", "Korean🇰🇷")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "Japanese"), TuplesKt.to("label", "Japanese🇯🇵")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "Chinese"), TuplesKt.to("label", "Chinese🇨🇳")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("value", "Telugu"), TuplesKt.to("label", "Telugu🇮🇳")})}))});

    /* JADX WARN: Code duplicated, block: B:26:0x0078  */
    @NotNull
    public static final String cleanTitle(@Nullable String raw) {
        Integer epEnd;
        String episodes;
        String str = raw;
        if (str == null || StringsKt.isBlank(str)) {
            return "";
        }
        Regex regex = new Regex("S(\\d+)[Ee](\\d+)(?:-(\\d+))?");
        MatchResult match = Regex.find$default(regex, raw, 0, 2, (Object) null);
        if (match == null) {
            return StringsKt.trim(raw).toString();
        }
        int season = Integer.parseInt((String) match.getGroupValues().get(1));
        int epStart = Integer.parseInt((String) match.getGroupValues().get(2));
        String it = (String) CollectionsKt.getOrNull(match.getGroupValues(), 3);
        if (it == null) {
            epEnd = null;
        } else {
            if (!(it.length() > 0)) {
                it = null;
            }
            if (it != null) {
                epEnd = Integer.valueOf(Integer.parseInt(it));
            } else {
                epEnd = null;
            }
        }
        String showName = StringsKt.trim(StringsKt.substringBefore$default(raw, match.getValue(), (String) null, 2, (Object) null)).toString();
        if (epEnd != null) {
            episodes = "Episodes " + epStart + (char) 8211 + epEnd.intValue();
        } else {
            episodes = "Episode " + epStart;
        }
        return showName + " Season " + season + " | " + episodes;
    }

    @NotNull
    public static final List<ActorData> parseCredits(@Nullable String jsonText) {
        String str = jsonText;
        if (str == null || StringsKt.isBlank(str)) {
            return CollectionsKt.emptyList();
        }
        ArrayList list = new ArrayList();
        JSONObject root = new JSONObject(jsonText);
        JSONArray castArr = root.optJSONArray("cast");
        if (castArr == null) {
            return list;
        }
        int length = castArr.length();
        for (int i = 0; i < length; i++) {
            JSONObject c = castArr.optJSONObject(i);
            if (c != null) {
                String name = c.optString("name");
                if (StringsKt.isBlank(name)) {
                    name = null;
                }
                if (name == null && (name = c.optString("original_name")) == null) {
                    name = "";
                }
                String it = c.optString("profile_path");
                if (StringsKt.isBlank(it)) {
                    it = null;
                }
                String it2 = it != null ? "https://image.tmdb.org/t/p/original" + it : null;
                String it3 = c.optString("character");
                String character = StringsKt.isBlank(it3) ? null : it3;
                Actor actor = new Actor(name, it2);
                list.add(new ActorData(actor, (ActorRole) null, character, (Actor) null, 10, (DefaultConstructorMarker) null));
            }
        }
        return list;
    }

    @Nullable
    public static final SearchQuality getSearchQuality(@Nullable String check) {
        if (check == null) {
            return null;
        }
        String u = Normalizer.normalize(check, Normalizer.Form.NFKC).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(u, "toLowerCase(...)");
        List<Pair> patterns = CollectionsKt.listOf(new Pair[]{TuplesKt.to(new Regex("\\b(4k|ds4k|uhd|2160p)\\b", RegexOption.IGNORE_CASE), SearchQuality.FourK), TuplesKt.to(new Regex("\\b(hdts|hdcam|hdtc)\\b", RegexOption.IGNORE_CASE), SearchQuality.HdCam), TuplesKt.to(new Regex("\\b(camrip|cam[- ]?rip)\\b", RegexOption.IGNORE_CASE), SearchQuality.CamRip), TuplesKt.to(new Regex("\\b(cam)\\b", RegexOption.IGNORE_CASE), SearchQuality.Cam), TuplesKt.to(new Regex("\\b(web[- ]?dl|webrip|webdl)\\b", RegexOption.IGNORE_CASE), SearchQuality.WebRip), TuplesKt.to(new Regex("\\b(bluray|bdrip|blu[- ]?ray)\\b", RegexOption.IGNORE_CASE), SearchQuality.BlueRay), TuplesKt.to(new Regex("\\b(1440p|qhd)\\b", RegexOption.IGNORE_CASE), SearchQuality.BlueRay), TuplesKt.to(new Regex("\\b(1080p|fullhd)\\b", RegexOption.IGNORE_CASE), SearchQuality.HD), TuplesKt.to(new Regex("\\b(720p)\\b", RegexOption.IGNORE_CASE), SearchQuality.SD), TuplesKt.to(new Regex("\\b(hdrip|hdtv)\\b", RegexOption.IGNORE_CASE), SearchQuality.HD), TuplesKt.to(new Regex("\\b(dvd)\\b", RegexOption.IGNORE_CASE), SearchQuality.DVD), TuplesKt.to(new Regex("\\b(hq)\\b", RegexOption.IGNORE_CASE), SearchQuality.HQ), TuplesKt.to(new Regex("\\b(rip)\\b", RegexOption.IGNORE_CASE), SearchQuality.CamRip)});
        for (Pair pair : patterns) {
            Regex regex = (Regex) pair.component1();
            SearchQuality quality = (SearchQuality) pair.component2();
            if (regex.containsMatchIn(u)) {
                return quality;
            }
        }
        return null;
    }

    @NotNull
    public static final String buildExtractedTitle(@NotNull Map<String, ? extends List<String>> map) {
        Iterable orderedCategories = CollectionsKt.listOf(new String[]{"quality", "codec", "audio", "hdr", "language"});
        Iterable $this$flatMap$iv = orderedCategories;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$flatMap$iv) {
            String it = (String) element$iv$iv;
            Iterable iterableEmptyList = (List) map.get(it);
            if (iterableEmptyList == null) {
                iterableEmptyList = CollectionsKt.emptyList();
            }
            Iterable list$iv$iv = iterableEmptyList;
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
        }
        String specs = CollectionsKt.joinToString$default(CollectionsKt.distinct((List) destination$iv$iv), " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        List<String> list = map.get("size");
        String size = list != null ? (String) CollectionsKt.firstOrNull(list) : null;
        if (size != null) {
            return specs + " [" + size + ']';
        }
        return specs;
    }

    @NotNull
    public static final Map<String, List<Map<String, String>>> getSPEC_OPTIONS() {
        return SPEC_OPTIONS;
    }

    @NotNull
    public static final Map<String, List<String>> extractSpecs(@NotNull String inputString) {
        Map results = new LinkedHashMap();
        Map<String, List<Map<String, String>>> map = SPEC_OPTIONS;
        int $i$f$forEach = 0;
        Iterator<Map.Entry<String, List<Map<String, String>>>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, List<Map<String, String>>> next = it.next();
            String category = next.getKey();
            Iterable $this$filter$iv = (List) next.getValue();
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                Map<String, List<Map<String, String>>> map2 = map;
                Map option = (Map) element$iv$iv;
                int $i$f$forEach2 = $i$f$forEach;
                Object obj = option.get("value");
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                String value = (String) obj;
                Iterator<Map.Entry<String, List<Map<String, String>>>> it2 = it;
                Map.Entry<String, List<Map<String, String>>> entry = next;
                Regex regexPattern = new Regex("\\b" + Regex.Companion.escape(value) + "\\b", RegexOption.IGNORE_CASE);
                if (regexPattern.containsMatchIn(inputString)) {
                    destination$iv$iv.add(element$iv$iv);
                }
                map = map2;
                $i$f$forEach = $i$f$forEach2;
                it = it2;
                next = entry;
            }
            Map<String, List<Map<String, String>>> map3 = map;
            int $i$f$forEach3 = $i$f$forEach;
            Iterator<Map.Entry<String, List<Map<String, String>>>> it3 = it;
            Iterable $this$map$iv = (List) destination$iv$iv;
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                Map it4 = (Map) item$iv$iv;
                Object obj2 = it4.get("label");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                destination$iv$iv2.add((String) obj2);
            }
            results.put(category, (List) destination$iv$iv2);
            map = map3;
            $i$f$forEach = $i$f$forEach3;
            it = it3;
        }
        Regex fileSizeRegex = new Regex("(\\d+(?:\\.\\d+)?\\s?(?:MB|GB))", RegexOption.IGNORE_CASE);
        MatchResult sizeMatch = Regex.find$default(fileSizeRegex, inputString, 0, 2, (Object) null);
        if (sizeMatch != null) {
            results.put("size", CollectionsKt.listOf(sizeMatch.getGroupValues().get(1)));
        }
        return MapsKt.toMap(results);
    }

    public static final int getIndexQuality(@Nullable String str) {
        List groupValues;
        String str2;
        Integer intOrNull;
        MatchResult matchResultFind$default = Regex.find$default(new Regex("(\\d{3,4})[pP]"), str == null ? "" : str, 0, 2, (Object) null);
        return (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null || (str2 = (String) CollectionsKt.getOrNull(groupValues, 1)) == null || (intOrNull = StringsKt.toIntOrNull(str2)) == null) ? Qualities.Unknown.getValue() : intOrNull.intValue();
    }

    @NotNull
    public static final String hindmoviezBase64Url(@NotNull String input) {
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(MainAPIKt.base64Encode(StringsKt.encodeToByteArray(input)), "+", "-", false, 4, (Object) null), "/", "_", false, 4, (Object) null), "=", "", false, 4, (Object) null);
    }
}
