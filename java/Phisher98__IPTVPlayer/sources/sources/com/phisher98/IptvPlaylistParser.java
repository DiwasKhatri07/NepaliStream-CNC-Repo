package com.phisher98;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlin.text.MatchGroup;
import kotlin.text.MatchGroupCollection;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: IPTVPlayer.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/IPTVPlayer/classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tJ\f\u0010\n\u001a\u00020\u0007*\u00020\u0007H\u0002J\f\u0010\u000b\u001a\u00020\f*\u00020\u0007H\u0002J\u000e\u0010\r\u001a\u0004\u0018\u00010\u0007*\u00020\u0007H\u0002J\u000e\u0010\u000e\u001a\u0004\u0018\u00010\u0007*\u00020\u0007H\u0002J\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u0007*\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J\u0018\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0012*\u00020\u0007H\u0002J\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u0007*\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0002¨\u0006\u0015"}, d2 = {"Lcom/phisher98/IptvPlaylistParser;", "", "<init>", "()V", "parseM3U", "Lcom/phisher98/Playlist;", "content", "", "input", "Ljava/io/InputStream;", "replaceQuotesAndTrim", "isExtendedM3u", "", "getTitle", "getUrl", "getUrlParameter", "key", "getAttributes", "", "getTagValue", "Companion", "IPTVPlayer"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nIPTVPlayer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IPTVPlayer.kt\ncom/phisher98/IptvPlaylistParser\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,416:1\n1795#2,10:417\n2068#2:427\n2069#2:429\n1805#2:430\n1#3:428\n*S KotlinDebug\n*F\n+ 1 IPTVPlayer.kt\ncom/phisher98/IptvPlaylistParser\n*L\n373#1:417,10\n373#1:427\n373#1:429\n373#1:430\n373#1:428\n*E\n"})
public final class IptvPlaylistParser {

    @NotNull
    public static final String EXT_INF = "#EXTINF";

    @NotNull
    public static final String EXT_M3U = "#EXTM3U";

    @NotNull
    public static final String EXT_VLC_OPT = "#EXTVLCOPT";

    @NotNull
    public final Playlist parseM3U(@NotNull String content) {
        byte[] bytes = content.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return parseM3U(new ByteArrayInputStream(bytes));
    }

    @NotNull
    public final Playlist parseM3U(@NotNull InputStream input) throws PlaylistParserException {
        Reader inputStreamReader = new InputStreamReader(input, Charsets.UTF_8);
        BufferedReader reader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
        if (!isExtendedM3u(reader.readLine())) {
            throw new PlaylistParserException.InvalidHeader();
        }
        final List playlistItems = new ArrayList();
        final Ref.ObjectRef currentTitle = new Ref.ObjectRef();
        final Ref.ObjectRef currentAttributes = new Ref.ObjectRef();
        currentAttributes.element = MapsKt.emptyMap();
        final Ref.ObjectRef currentUserAgent = new Ref.ObjectRef();
        final Ref.ObjectRef currentReferrer = new Ref.ObjectRef();
        final Ref.ObjectRef currentHeaders = new Ref.ObjectRef();
        currentHeaders.element = MapsKt.emptyMap();
        TextStreamsKt.forEachLine(reader, new Function1() { // from class: com.phisher98.IptvPlaylistParser$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return IptvPlaylistParser.parseM3U$lambda$0(currentTitle, this, currentAttributes, currentUserAgent, currentReferrer, currentHeaders, playlistItems, (String) obj);
            }
        });
        return new Playlist(playlistItems);
    }

    static final Unit parseM3U$lambda$0(Ref.ObjectRef $currentTitle, IptvPlaylistParser this$0, Ref.ObjectRef $currentAttributes, Ref.ObjectRef $currentUserAgent, Ref.ObjectRef $currentReferrer, Ref.ObjectRef $currentHeaders, List $playlistItems, String line) {
        Map urlHeaders;
        String trimmedLine = StringsKt.trim(line).toString();
        if (trimmedLine.length() == 0) {
            return Unit.INSTANCE;
        }
        if (StringsKt.startsWith$default(trimmedLine, EXT_INF, false, 2, (Object) null)) {
            $currentTitle.element = this$0.getTitle(trimmedLine);
            $currentAttributes.element = this$0.getAttributes(trimmedLine);
            $currentUserAgent.element = null;
            $currentReferrer.element = null;
            $currentHeaders.element = MapsKt.emptyMap();
        } else if (StringsKt.startsWith$default(trimmedLine, EXT_VLC_OPT, false, 2, (Object) null)) {
            String userAgent = this$0.getTagValue(trimmedLine, "http-user-agent");
            String referrer = this$0.getTagValue(trimmedLine, "http-referrer");
            $currentUserAgent.element = userAgent == null ? (String) $currentUserAgent.element : userAgent;
            $currentReferrer.element = referrer == null ? (String) $currentReferrer.element : referrer;
            if ($currentReferrer.element != null) {
                Map map = (Map) $currentHeaders.element;
                Object obj = $currentReferrer.element;
                Intrinsics.checkNotNull(obj);
                $currentHeaders.element = MapsKt.plus(map, MapsKt.mapOf(TuplesKt.to("referrer", obj)));
            }
        } else if (!StringsKt.startsWith$default(trimmedLine, "#", false, 2, (Object) null)) {
            String url = this$0.getUrl(trimmedLine);
            String uaParam = this$0.getUrlParameter(trimmedLine, "user-agent");
            String refParam = this$0.getUrlParameter(trimmedLine, "referer");
            String key = this$0.getUrlParameter(trimmedLine, "key");
            String keyid = this$0.getUrlParameter(trimmedLine, "keyid");
            String combinedUserAgent = uaParam == null ? (String) $currentUserAgent.element : uaParam;
            String ref = refParam == null ? (String) $currentReferrer.element : refParam;
            if (ref != null) {
                urlHeaders = MapsKt.plus((Map) $currentHeaders.element, MapsKt.mapOf(TuplesKt.to("referrer", ref)));
            } else {
                urlHeaders = (Map) $currentHeaders.element;
            }
            if ($currentTitle.element != null) {
                String str = (String) $currentTitle.element;
                if (str == null) {
                    str = "";
                }
                $playlistItems.add(new PlaylistItem(str, (Map) $currentAttributes.element, urlHeaders, url, combinedUserAgent, key, keyid));
            }
            $currentTitle.element = null;
            $currentAttributes.element = MapsKt.emptyMap();
            $currentUserAgent.element = null;
            $currentReferrer.element = null;
            $currentHeaders.element = MapsKt.emptyMap();
        }
        return Unit.INSTANCE;
    }

    private final String replaceQuotesAndTrim(String $this$replaceQuotesAndTrim) {
        return StringsKt.trim(StringsKt.replace$default($this$replaceQuotesAndTrim, "\"", "", false, 4, (Object) null)).toString();
    }

    private final boolean isExtendedM3u(String $this$isExtendedM3u) {
        return StringsKt.startsWith$default($this$isExtendedM3u, EXT_M3U, false, 2, (Object) null);
    }

    private final String getTitle(String $this$getTitle) {
        String str = (String) CollectionsKt.lastOrNull(StringsKt.split$default($this$getTitle, new String[]{","}, false, 0, 6, (Object) null));
        if (str != null) {
            return replaceQuotesAndTrim(str);
        }
        return null;
    }

    private final String getUrl(String $this$getUrl) {
        String str = (String) CollectionsKt.firstOrNull(StringsKt.split$default($this$getUrl, new String[]{"|"}, false, 0, 6, (Object) null));
        if (str != null) {
            return replaceQuotesAndTrim(str);
        }
        return null;
    }

    private final String getUrlParameter(String $this$getUrlParameter, String key) {
        MatchGroupCollection groups;
        MatchGroup matchGroup;
        Regex urlRegex = new Regex("^(.*)\\|", RegexOption.IGNORE_CASE);
        Regex keyRegex = new Regex(key + "=(\\w[^&]*)", RegexOption.IGNORE_CASE);
        String paramsString = replaceQuotesAndTrim(urlRegex.replace($this$getUrlParameter, ""));
        MatchResult matchResultFind$default = Regex.find$default(keyRegex, paramsString, 0, 2, (Object) null);
        if (matchResultFind$default == null || (groups = matchResultFind$default.getGroups()) == null || (matchGroup = groups.get(1)) == null) {
            return null;
        }
        return matchGroup.getValue();
    }

    private final Map<String, String> getAttributes(String $this$getAttributes) {
        Regex extInfRegex = new Regex("(#EXTINF:.?[0-9]+)", RegexOption.IGNORE_CASE);
        String attributesString = (String) CollectionsKt.first(StringsKt.split$default(replaceQuotesAndTrim(extInfRegex.replace($this$getAttributes, "")), new String[]{","}, false, 0, 6, (Object) null));
        Iterable $this$mapNotNull$iv = new Regex("\\s").split(attributesString, 0);
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            String it = (String) element$iv$iv$iv;
            List pair = StringsKt.split$default(it, new String[]{"="}, false, 0, 6, (Object) null);
            Regex extInfRegex2 = extInfRegex;
            String attributesString2 = attributesString;
            Pair pair2 = pair.size() == 2 ? TuplesKt.to(CollectionsKt.first(pair), replaceQuotesAndTrim((String) CollectionsKt.last(pair))) : null;
            if (pair2 != null) {
                destination$iv$iv.add(pair2);
            }
            extInfRegex = extInfRegex2;
            attributesString = attributesString2;
        }
        return MapsKt.toMap((List) destination$iv$iv);
    }

    private final String getTagValue(String $this$getTagValue, String key) {
        MatchGroupCollection groups;
        MatchGroup matchGroup;
        String value;
        Regex keyRegex = new Regex(key + "=(.*)", RegexOption.IGNORE_CASE);
        MatchResult matchResultFind$default = Regex.find$default(keyRegex, $this$getTagValue, 0, 2, (Object) null);
        if (matchResultFind$default == null || (groups = matchResultFind$default.getGroups()) == null || (matchGroup = groups.get(1)) == null || (value = matchGroup.getValue()) == null) {
            return null;
        }
        return replaceQuotesAndTrim(value);
    }
}
