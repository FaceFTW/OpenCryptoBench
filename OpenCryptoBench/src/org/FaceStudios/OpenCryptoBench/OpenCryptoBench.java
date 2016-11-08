package org.FaceStudios.OpenCryptoBench;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.security.Permission;
import java.security.PermissionCollection;
import java.util.Map;

import org.FaceStudios.OpenCryptoBench.Executable.NOGUI;

public class OpenCryptoBench {
	
	public static void main(String[] args) {
		removeCryptographyRestrictions();
		NOGUI.doNOGUI();
	}
	
	private static void removeCryptographyRestrictions() {
	    //This code is from ntoskrnl on stackoverflow
		//http://stackoverflow.com/a/22492582/7127790
		if (!isRestrictedCryptography()) {
	        return;
	    }
	    try {
	        final Class<?> jceSecurity = Class.forName("javax.crypto.JceSecurity");
	        final Class<?> cryptoPermissions = Class.forName("javax.crypto.CryptoPermissions");
	        final Class<?> cryptoAllPermission = Class.forName("javax.crypto.CryptoAllPermission");
	        final Field isRestrictedField = jceSecurity.getDeclaredField("isRestricted");
	        isRestrictedField.setAccessible(true);
	        final Field modifiersField = Field.class.getDeclaredField("modifiers");
	        modifiersField.setAccessible(true);
	        modifiersField.setInt(isRestrictedField, isRestrictedField.getModifiers() & ~Modifier.FINAL);
	        isRestrictedField.set(null, false);
	        final Field defaultPolicyField = jceSecurity.getDeclaredField("defaultPolicy");
	        defaultPolicyField.setAccessible(true);
	        final PermissionCollection defaultPolicy = (PermissionCollection) defaultPolicyField.get(null);
	        final Field perms = cryptoPermissions.getDeclaredField("perms");
	        perms.setAccessible(true);
	        ((Map<?, ?>) perms.get(defaultPolicy)).clear();
	        final Field instance = cryptoAllPermission.getDeclaredField("INSTANCE");
	        instance.setAccessible(true);
	        defaultPolicy.add((Permission) instance.get(null));
	    } catch (final Exception e) {
	       e.printStackTrace();
	    }
	}

	private static boolean isRestrictedCryptography() {
	    return "Java(TM) SE Runtime Environment".equals(System.getProperty("java.runtime.name"));
	}

}
