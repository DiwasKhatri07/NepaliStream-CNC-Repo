package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: UltimaBackupUtils.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Ultima/classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0016\b\u0001\u0010\u0006\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J9\u0010\u000e\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0016\b\u0003\u0010\u0006\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R%\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR%\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/phisher98/BackupFile;", "", "datastore", "Lcom/phisher98/BackupVars;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "settings", "<init>", "(Lcom/phisher98/BackupVars;Lcom/phisher98/BackupVars;)V", "getDatastore", "()Lcom/phisher98/BackupVars;", "getSettings", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Ultima"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class BackupFile {

    @JsonProperty("datastore")
    @NotNull
    private final BackupVars datastore;

    @JsonProperty("settings")
    @NotNull
    private final BackupVars settings;

    public static /* synthetic */ BackupFile copy$default(BackupFile backupFile, BackupVars backupVars, BackupVars backupVars2, int i, Object obj) {
        if ((i & 1) != 0) {
            backupVars = backupFile.datastore;
        }
        if ((i & 2) != 0) {
            backupVars2 = backupFile.settings;
        }
        return backupFile.copy(backupVars, backupVars2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final BackupVars getDatastore() {
        return this.datastore;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final BackupVars getSettings() {
        return this.settings;
    }

    @NotNull
    public final BackupFile copy(@JsonProperty("datastore") @NotNull BackupVars datastore, @JsonProperty("settings") @NotNull BackupVars settings) {
        return new BackupFile(datastore, settings);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BackupFile)) {
            return false;
        }
        BackupFile backupFile = (BackupFile) other;
        return Intrinsics.areEqual(this.datastore, backupFile.datastore) && Intrinsics.areEqual(this.settings, backupFile.settings);
    }

    public int hashCode() {
        return (this.datastore.hashCode() * 31) + this.settings.hashCode();
    }

    @NotNull
    public String toString() {
        return "BackupFile(datastore=" + this.datastore + ", settings=" + this.settings + ')';
    }

    public BackupFile(@JsonProperty("datastore") @NotNull BackupVars datastore, @JsonProperty("settings") @NotNull BackupVars settings) {
        this.datastore = datastore;
        this.settings = settings;
    }

    @NotNull
    public final BackupVars getDatastore() {
        return this.datastore;
    }

    @NotNull
    public final BackupVars getSettings() {
        return this.settings;
    }
}
